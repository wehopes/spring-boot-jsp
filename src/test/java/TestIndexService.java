import com.ruituo.WebApplication;
import com.ruituo.serviceImpl.IndexService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * description
 *
 * @author huijunjie
 * @date 2018-05-22 下午 3:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebApplication.class})
public class TestIndexService {

    @Autowired
    private IndexService indexService;

    @Test
    public void textIndex(){
        System.out.println(indexService.index());
    }
}
