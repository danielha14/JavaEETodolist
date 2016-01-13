package com.project.todolist.servies;

import javax.ws.rs.*;

@Path("/coupons/{couponid}")
public class Coupon {
    @GET
    @Produces("text/html")
    public String getUser(@PathParam("couponid") String id) {
    	return "details about coupon "+id;
   
    }
}