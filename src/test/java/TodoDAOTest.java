import com.green.jdbcex.dao.TodoDAO;
import com.green.jdbcex.domain.TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TodoDAOTest {
    private TodoDAO todoDAO;

//    TodoDAOTest() {
//        todoDAO = new TodoDAO();
//    }
    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }


    @Test
    void testTime() throws Exception {
        System.out.println("현재 시각 : " + todoDAO.getTime());
    }
    @Test
    public void testinsert() throws Exception{
        TodoVO todoVO = TodoVO.builder()
                .title("sample Title")
                .dueDate(LocalDate.of(2021,4,4))
                .build();

        todoDAO.insert(todoVO);
    }



}
