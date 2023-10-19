package services;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class EntityManagerAdmin {
    private static EntityManager instance;
    private static final String UNIDAD = "encuestaJPA";
    public static EntityManager getInstance(){
        if (instance == null){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIDAD);
            return emf.createEntityManager();
        }
        return instance;
    }
    private EntityManagerAdmin(){}
}
