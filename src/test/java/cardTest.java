
import java.sql.SQLException;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import opal.dao.CardManagementDao;
import opal.entity.OpalCard;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chengming
 */
public class cardTest {
    CardManagementDao cardDao;

    public cardTest() throws ClassNotFoundException, SQLException {
        this.cardDao = new CardManagementDao();
    }
    
    @Test
    public void testGetAllCards() throws SQLException{
        List<OpalCard> list = cardDao.getAllCards();
        assertTrue(list.size() > 0);
    }
    
    @Test public void testCreate() throws SQLException {
    System.out.println("Running testCreate...");
       
    OpalCard opalcard = new OpalCard(8,"888888", "3333","Lily","Adult");
    cardDao.AddCard(opalcard);
    
    OpalCard acard=cardDao.SearchbyId(opalcard.getCardId());
    assertTrue(opalcard.getCardId() > 0);
    }
    
    @Test public void testUpdate() throws SQLException {
    System.out.println("Running testUpdate..."); 
    Integer id = 9;
    OpalCard opalcard = new OpalCard(id,"999999","9999","Alan","Student"); 
    OpalCard updatedCard = new OpalCard(id,"999999","9000","Mike","Child");
  
    String newCardNo=updatedCard.getCardNo();
    String oldCardNo=opalcard.getCardNo();
    String newSecurityCode=updatedCard.getsecurityCode();
    String oldSecurityCode=opalcard.getsecurityCode();
    String newNickname=updatedCard.getnickname();
    String oldNickname=opalcard.getnickname();
    String newCardType=updatedCard.getcardType();
    String oldCardType=opalcard.getcardType();
    assertTrue(newCardNo!=oldCardNo || newSecurityCode!=oldSecurityCode || newNickname!=oldNickname||newCardType!=oldCardType);
    }
}

