package uib.swarchitecture.quepasa.infrastructure.database.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import uib.swarchitecture.quepasa.domain.models.Chat;
import uib.swarchitecture.quepasa.domain.models.Message;
import uib.swarchitecture.quepasa.domain.models.enums.ChatType;
import uib.swarchitecture.quepasa.domain.models.enums.MessageType;
import uib.swarchitecture.quepasa.domain.ports.MessagePort;
import uib.swarchitecture.quepasa.infrastructure.database.models.ChatJPA;
import uib.swarchitecture.quepasa.infrastructure.database.models.MessageJPA;
import uib.swarchitecture.quepasa.infrastructure.database.models.UserJPA;
import uib.swarchitecture.quepasa.infrastructure.database.models.enums.ChatTypeJPA;
import uib.swarchitecture.quepasa.infrastructure.database.models.enums.MessageTypeJPA;
import uib.swarchitecture.quepasa.infrastructure.database.repository.ChatRepository;
import uib.swarchitecture.quepasa.infrastructure.database.repository.MessageRepository;
import uib.swarchitecture.quepasa.infrastructure.database.repository.UserRepository;
import uib.swarchitecture.quepasa.infrastructure.web.models.SendMessageRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class MessageAdapter implements MessagePort {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final ChatRepository chatRepository;

    @Autowired
    public MessageAdapter(MessageRepository messageRepository, UserRepository userRepository, ChatRepository chatRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
        this.chatRepository = chatRepository;
    }

    @Override
    public Optional<Message> getLastMessage(long chatId) {
        Pageable pageable = PageRequest.of(0, 1); // Página 0, tamaño de página 1
        List<MessageJPA> messages = messageRepository.findMessagesByChatId(chatId, pageable);
        Optional<MessageJPA> lastMessage = messages.isEmpty() ? Optional.empty() : Optional.of(messages.getFirst());

        return lastMessage.map(this::convertToMessage);
    }

    @Override
    public List<Message> getMessagesFromChat(long chatId) {
        Pageable pageable = PageRequest.of(0, 50); // Página 0, tamaño de página 1
        List<MessageJPA> messageJPAS = messageRepository.findMessagesByChatId(chatId, pageable);
        List<Message> messages = new ArrayList<>();

        for (MessageJPA messageJPA : messageJPAS) {
            Message message = convertToMessage(messageJPA);
            messages.add(message);
            System.out.println(message);
        }

        return messages;
    }

    @Override
    public Message saveMessage(SendMessageRequest message, long chatId, long userId) {
        // Cargar entidades relacionadas
        UserJPA author = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with id " + userId));

        ChatJPA chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new NoSuchElementException("Chat not found with id " + chatId));

        // Construir MessageJPA
        MessageJPA messageJPA = convertToMessageJPA(message, chat, author);

        // Guardar en la base de datos
        MessageJPA savedMessage = messageRepository.save(messageJPA);
        return convertToMessage(savedMessage);
    }



    @Override
    public Optional<Message> getMessageById(long messageId) {
        return messageRepository.findById(messageId)
                .map(this::convertToMessage);
    }

    private MessageJPA convertToMessageJPA(SendMessageRequest message, ChatJPA chat, UserJPA author) {
        return MessageJPA.builder()
                .content(message.getContent())
                .timestamp(LocalDateTime.now())
                .type(convertMessageTypeToJPA(message.getType()))
                .author(author)
                .chat(chat)
                .build();
    }

    private MessageTypeJPA convertMessageTypeToJPA(MessageType type) {
        return switch (type) {
            case TEXT -> MessageTypeJPA.TEXT;
            case IMAGE -> MessageTypeJPA.IMAGE;
        };
    }

    private Message convertToMessage(MessageJPA messageJPA) {
        return Message.builder()
                .id(messageJPA.getId())
                .content(messageJPA.getContent())
                .timestamp(messageJPA.getTimestamp())
                .type(convertMessageType(messageJPA.getType()))
                .build();
    }

    private MessageType convertMessageType(MessageTypeJPA messageTypeJPA) {
        return switch (messageTypeJPA) {
            case TEXT -> MessageType.TEXT;
            case IMAGE -> MessageType.IMAGE;
        };
    }
}
