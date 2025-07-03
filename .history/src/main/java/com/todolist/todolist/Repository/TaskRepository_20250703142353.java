import org.springframework.data.mongodb.repository.MongoRepository;
import com.todolist.todolist.M;


public interface TaskRepository extends MongoRepository<Task, String> {
}
