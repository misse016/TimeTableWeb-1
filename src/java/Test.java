
import com.ttable.dao.DAO;
import com.ttable.dao.DayDAO;
import com.ttable.dao.LevelDAO;
import com.ttable.dao.PeriodDAO;
import com.ttable.model.Day;
import com.ttable.model.Level;
import com.ttable.model.Period;
import com.ttable.util.DbUtil;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MIS
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DAO<Period> PeriodDAO = new PeriodDAO(DbUtil.getConnection());
        String stime = "07:00:00";
        String etime = "11:00:00";
        Period p = new Period(1, Time.valueOf(stime), Time.valueOf(etime));
        
        
        List<Period> periods = new ArrayList<Period>();
        periods = PeriodDAO.getAll();
        System.out.println(periods.get(0).getEndTime());
        
        System.out.println(" IT WORKS");
    }
    
}
