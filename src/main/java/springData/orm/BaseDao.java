package springData.orm;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BaseDao<T,PK extends Serializable> extends JpaRepository<T, PK>,JpaSpecificationExecutor<T>{

}
