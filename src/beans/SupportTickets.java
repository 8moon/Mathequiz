package beans;

import java.io.Serializable;

public class SupportTickets implements Serializable{
    private int ticketId;
    private String ticketMail;
    private String ticketFirstName;
    private String ticketLastName;
    private String ticketMessage;

    public SupportTickets() {
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketMail() {
        return ticketMail;
    }

    public void setTicketMail(String ticketMail) {
        this.ticketMail = ticketMail;
    }

    public String getTicketFirstName() {
        return ticketFirstName;
    }

    public void setTicketFirstName(String ticketFirstName) {
        this.ticketFirstName = ticketFirstName;
    }

    public String getTicketLastName() {
        return ticketLastName;
    }

    public void setTicketLastName(String ticketLastName) {
        this.ticketLastName = ticketLastName;
    }

    public String getTicketMessage() {
        return ticketMessage;
    }

    public void setTicketMessage(String ticketMessage) {
        this.ticketMessage = ticketMessage;
    }
}
