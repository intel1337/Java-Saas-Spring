import org.springframework.data.mongodb.repository.MongoRepository;
import com.todolist.todolist.Repository.mo;


public interface TaskRepository extends MongoRepository<Task, String> {
}
