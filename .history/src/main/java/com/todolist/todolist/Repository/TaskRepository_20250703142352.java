import org.springframework.data.mongodb.repository.MongoRepository;
import com.todolist.todolist.Repositor;


public interface TaskRepository extends MongoRepository<Task, String> {
}
