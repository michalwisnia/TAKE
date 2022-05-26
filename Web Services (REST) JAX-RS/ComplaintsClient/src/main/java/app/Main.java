/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author micha
 */
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Main {
    public static void main(String[] args){
        Client client = ClientBuilder.newClient();
        String count = client.target("http://localhost:8080/Complaints/" + "resources/complaints/entities.complaint/count")
        .request(MediaType.TEXT_PLAIN)
        .get(String.class);
        System.out.println("Count: " + count);
        
        String allComplaints = client.target("http://localhost:8080/Complaints/resources/complaints/entities.complaint")
                .request(MediaType.APPLICATION_JSON).get(String.class);
        
        System.out.println("all complaints: " + allComplaints);
        
        String oneComplaint = client.target("http://localhost:8080/Complaints/resources/complaints/entities.complaint/303")
                .request(MediaType.APPLICATION_JSON).get(String.class);
        
        System.out.println("chosen complaint: " + oneComplaint);
        
        oneComplaint = oneComplaint.replace("open", "closed");
        
        Response res = client.target("http://localhost:8080/Complaints/resources/complaints/entities.complaint/303")
                .request(MediaType.APPLICATION_JSON).put(Entity.entity(oneComplaint, MediaType.APPLICATION_JSON));
        
        String c = client.target("http://localhost:8080/Complaints/resources/complaints/entities.complaint/303")
                .request(MediaType.APPLICATION_JSON).get(String.class);
        
        System.out.println("Chosen Complaint: " + c);
        
        String allOpenComplaints = client.target("http://localhost:8080/Complaints/resources/complaints/entities.complaint?status=open")
                .request(MediaType.APPLICATION_JSON).get(String.class);
        
        System.out.println("all open complaints: " + allOpenComplaints);
        
        client.close();
    }    
}