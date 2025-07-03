import org.springframework.data.mongodb.repository.MongoRepository;
import com.todolist.todolist.Repository.TaskRepository;
import com

public interface TaskRepository extends MongoRepository<Task, String> {
}
