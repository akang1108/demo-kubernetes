package info.akang.demo.demoapi

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/messages")
class MessageController {
    @Autowired
    private lateinit var messageService: MessageService

    @GetMapping
    fun getMessages(): List<Message> {
        return messageService.getMessages()
    }

    @GetMapping("/{id}")
    fun getMessage(@PathVariable("id") id: String): ResponseEntity<Message> {
        val messageOpt = messageService.getMessage(id)
        return if (messageOpt != null)
            ResponseEntity(messageOpt, HttpStatus.OK)
        else
            ResponseEntity(null, HttpStatus.NOT_FOUND)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createMessage(@RequestBody message: Message): Unit {
        messageService.createMessage(message)
    }
}

data class Message(val id: String?, val message: String)

@Service
class MessageService {
    private val messages: MutableMap<String, Message> = mutableMapOf()

    fun getMessages() = messages.values.toList()
    fun getMessage(id: String): Message? = messages[id]
    fun createMessage(message: Message) = synchronized(messages) {
        val id = UUID.randomUUID().toString()
        messages.put(id, Message(id, message.message))
    }
}

