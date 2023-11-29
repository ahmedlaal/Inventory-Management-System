import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.Inventory.Management.System.Controller", 
"com.example.Inventory.Management.System.Entity", "com.example.Inventory.Management.System.Repository", 
"com.example.Inventory.Management.System.Service"})
public class AppConfig {
    // Additional configurations or beans can be defined here if needed
}