package bg.soft_uni.pathfinderapp.Services;

import bg.soft_uni.pathfinderapp.Repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
}
