package bg.soft_uni.pathfinderapp.Services;

import bg.soft_uni.pathfinderapp.Model.Dtos.AddRouteDto;
import bg.soft_uni.pathfinderapp.Model.Dtos.RouteExportDto;
import bg.soft_uni.pathfinderapp.Model.Entities.Category;
import bg.soft_uni.pathfinderapp.Model.Entities.Enums.CategoryType;
import bg.soft_uni.pathfinderapp.Model.Entities.Picture;
import bg.soft_uni.pathfinderapp.Model.Entities.Route;
import bg.soft_uni.pathfinderapp.Repositories.CategoryRepository;
import bg.soft_uni.pathfinderapp.Repositories.PictureRepository;
import bg.soft_uni.pathfinderapp.Repositories.RouteRepository;
import bg.soft_uni.pathfinderapp.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RouteService {
    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;
    private final CategoryRepository categoryRepository;

    public RouteService(RouteRepository routeRepository, ModelMapper modelMapper, UserRepository userRepository, PictureRepository pictureRepository, CategoryRepository categoryRepository) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
        this.categoryRepository = categoryRepository;
    }
    @Transactional
    public List<RouteExportDto> getAllRoutes() {
        List<Route> all = this.routeRepository.findAll();
        List<RouteExportDto> collect = all.stream()
                .map(route -> {
                    RouteExportDto map = modelMapper.map(route, RouteExportDto.class);
                    List<Picture> allByTitle = this.pictureRepository.findAllByTitle(route.getName());
                    if(allByTitle.isEmpty()){
                        Random random = new Random();
                        int randomIntInRange = random.nextInt(Integer.parseInt(String.valueOf(this.pictureRepository.count())));
                        route.setVideoUrl(this.pictureRepository.findById(Long.valueOf(String.valueOf(randomIntInRange+1))).get().getUrl());
                    }else{
                        route.setVideoUrl(allByTitle.get(0).getUrl());
                    }
                    return map;
                })
                .collect(Collectors.toList());
        return collect;
    }

    public void addRoute(AddRouteDto addRouteDto, MultipartFile multipartFile, Principal principal) throws IllegalAccessException {
        Route map = this.modelMapper.map(addRouteDto, Route.class);
        map.setUser(this.userRepository.findByUsername(principal.getName()).get());
        String categories = addRouteDto.getCategories();
        CategoryType categoryType = CategoryType.valueOf(categories.toUpperCase());
        ArrayList<Category> resultCategory = new ArrayList<>();
        resultCategory.add(this.categoryRepository.findByName(categoryType).get());
        map.setCategories(resultCategory);

        Path destinationFile = Paths.get("src", "main", "resources", "uploads", multipartFile.getOriginalFilename())
                .normalize()
                .toAbsolutePath();

        try(InputStream inputStream = multipartFile.getInputStream()){
            Files.copy(inputStream, destinationFile , StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        map.setGpxCoordinates(destinationFile.toString());
        this.routeRepository.saveAndFlush(map);
    }

    public RouteExportDto getRouteById(Long id) {
        Route route = this.routeRepository.findById(id).get();
        return getRouteExportDto(route);
    }
    @Transactional
    public List<RouteExportDto> getByType(String type) {
            CategoryType categoryType = CategoryType.valueOf(type);
            Category category = this.categoryRepository.findByName(categoryType).get();
            List<Route> routeStream = this.routeRepository.findAll().stream().filter(r -> r.getCategories().contains(category)).toList();
            return routeStream.stream().map(this::getRouteExportDto).toList();
    }

    private RouteExportDto getRouteExportDto(Route r) {
        RouteExportDto map = this.modelMapper.map(r, RouteExportDto.class);
        map.setPhoto(this.pictureRepository.findAllByTitle(r.getName()).stream().map(Picture::getUrl).toList());
        map.setUserName(r.getUser().getUsername());
        map.setLevel(r.getLevel().name());
        map.setVideoUrl(r.getVideoUrl());
        return map;
    }
}
