package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Stateless
@LocalBean
@Entity
public class Notifications implements Serializable {
   
    private String msg;
    private Date notifications_datetime;
    private static final long serialVersionUID=1L;

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="notId")
    private User user;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getNotifications_datetime() {
        return notifications_datetime;
    }

    public void setNotifications_datetime(Date notifications_datetime) {
        this.notifications_datetime = notifications_datetime;
    }


   

}