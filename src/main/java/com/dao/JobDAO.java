package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.Jobs;
//import com.sun.tools.javac.util.*;
import java.util.*;
import com.entity.Jobs;
import java.util.ArrayList;
import java.util.Collections;




import org.w3c.dom.stylesheets.LinkStyle;


public class JobDAO {

	private Connection conn;
	
	public JobDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addJobs(Jobs j)
	{
		boolean f=false;
		
		try {
			
			String sql="insert into jobs(title,description,category,status,location) values(?,?,?,?,?) ";
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,j.getTitle());
			ps.setString(2,j.getDescription());
			ps.setString(3,j.getCategory());
			ps.setString(4,j.getStatus());
			ps.setString(5,j.getLocation());
			
			int i=ps.executeUpdate();
			
			if(i == 1) {
				f = true;
			}
				
			
	    	} catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	    public ArrayList<Jobs> getAllJobs()
	    {
	        ArrayList<Jobs> list=new ArrayList<Jobs>();
	        Jobs j=null;
	    	
		  
		  try {
			  
			  String sql="select * from jobs order by id desc";
			  PreparedStatement ps=conn.prepareStatement(sql);
			  ResultSet rs=ps.executeQuery();
			  while(rs.next())
			  {
				  j=new Jobs();
				  j.setId(rs.getInt(1));
				  j.setTitle(rs.getString(2));
				  j.setDescription(rs.getString(3));
				  j.setCategory(rs.getString(4));
				  j.setStatus(rs.getString(5));
				  j.setLocation(rs.getString(6));
				  j.setPdate(rs.getTimestamp(7)+"");
				  list.add(j);
				  
			  }
			  
		  } catch (Exception e) {
			  e.printStackTrace();
		  }

	    
		  
		  return list;
	    }
        
	    public Jobs getJobsById(int id)
	    {
	        
	        Jobs j=null;
	    	
		  
		  try {
			  
			  String sql="select * from jobs where id=?";
			  PreparedStatement ps=conn.prepareStatement(sql);
			  ps.setInt(1, id);
			  ResultSet rs=ps.executeQuery();
			  while(rs.next())
			  {
				  j=new Jobs();
				  j.setId(rs.getInt(1));
				  j.setTitle(rs.getString(2));
				  j.setDescription(rs.getString(3));
				  j.setCategory(rs.getString(4));
				  j.setStatus(rs.getString(5));
				  j.setLocation(rs.getString(6));
				  j.setPdate(rs.getTimestamp(7)+"");	  
			  }
			  
		  } catch (Exception e) {
			  e.printStackTrace();
		  }

	    
		  
		  return j;
	    }
	    
	    public boolean updateJob(Jobs j)
	    {
	    	boolean f=false;
			
			try {
				
				String sql="update jobs set title=?,description=?,category=?,status=?,location=? where id=? ";
				
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1,j.getTitle());
				ps.setString(2,j.getDescription());
				ps.setString(3,j.getCategory());
				ps.setString(4,j.getStatus());
				ps.setString(5,j.getLocation());
				ps.setInt(6,j.getId());
				
				int i=ps.executeUpdate();
				
				if(i == 1) {
					f = true;
				}
					
				
		    	} catch(Exception e) {
				e.printStackTrace();
			}
			return f;
			
		
	    	
	    }
	    
	    public boolean deleteJobs(int id)
	    {
	    	boolean f=false;
	    	
	    	try {
				String sql="delete from jobs where id=? ";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, id);
				
                int i=ps.executeUpdate();
				
				if(i == 1) {
					f = true;
				}
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    	return f;
	    }

	    
	    
	    public ArrayList<Jobs> getAllJobsForUser()
	    {
	        ArrayList<Jobs> list=new ArrayList<Jobs>();
	        Jobs j=null;
	    	
		  
		  try {
			  
			  String sql="select * from jobs where status=? order by id desc";
			  PreparedStatement ps=conn.prepareStatement(sql);
			  ps.setString(1, "Active");
			  ResultSet rs=ps.executeQuery();
			  while(rs.next())
			  {
				  j=new Jobs();
				  j.setId(rs.getInt(1));
				  j.setTitle(rs.getString(2));
				  j.setDescription(rs.getString(3));
				  j.setCategory(rs.getString(4));
				  j.setStatus(rs.getString(5));
				  j.setLocation(rs.getString(6));
				  j.setPdate(rs.getTimestamp(7)+"");
				  list.add(j);
				  
			  }
			  
		  } catch (Exception e) {
			  e.printStackTrace();
		  }

	    
		  
		  return list;
	    }
	    
	    public List<Jobs> getJobsORLocationORCate(String category, String location) {
	    	 
	    	   List<Jobs> list=new ArrayList<Jobs>();
	    
	    	   Jobs j = null;
	    	   try {
	    		   String sql= "select * from jobs where category=? or location=? order by id DESC";
	    		   PreparedStatement ps = conn.prepareStatement(sql);
	    		   ps.setString(1, category);
	    		   ps.setString(2, location);
	    		   
	    		   ResultSet rs = ps.executeQuery();
	    		   while (rs.next()) {
					j = new Jobs();
					j.setId(rs.getInt(1));
					j.setTitle(rs.getString(2));
					j.setDescription(rs.getString(3));
					j.setCategory(rs.getString(4));
					j.setStatus(rs.getString(5));
					j.setLocation(rs.getString(6));
				    j.setPdate(rs.getString(7));
					list.add(j);
				  }
	    	   } catch (Exception e) {
				  e.printStackTrace();
			}
	    	return list;
	    }

	    public List<Jobs> getJobsAndLocationAndCate(String category, String location) {
	    	 
	    	   List<Jobs> list=new ArrayList<Jobs>();
	    
	    	   Jobs j = null;
	    	   try {
	    		   String sql= "select * from jobs where category=? and location=? order by id DESC";
	    		   PreparedStatement ps = conn.prepareStatement(sql);
	    		   ps.setString(1, category);
	    		   ps.setString(2, location);
	    		   
	    		   ResultSet rs = ps.executeQuery();
	    		   while (rs.next()) {
					j = new Jobs();
					j.setId(rs.getInt(1));
					j.setTitle(rs.getString(2));
					j.setDescription(rs.getString(3));
					j.setCategory(rs.getString(4));
					j.setStatus(rs.getString(5));
					j.setLocation(rs.getString(6));
					j.setPdate(rs.getString(7));
					list.add(j);
				  }
	    	   } catch (Exception e) {
				  e.printStackTrace();
			}
	    	return list;
	    }

}
	

