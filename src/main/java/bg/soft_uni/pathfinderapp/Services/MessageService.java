package bg.soft_uni.pathfinderapp.Services;

import bg.soft_uni.pathfinderapp.Repositories.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
}
