package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

public class ClientDemo
{
 public static void main(String[] args)
 {

  SessionFactory factory =
   new Configuration().configure().buildSessionFactory();

  // INSERT RECORD
  Session session = factory.openSession();
  Transaction tx = session.beginTransaction();

  Restaurant r = new Restaurant();
  r.setId(1);
  r.setName("Paradise");
  r.setDate("2026-03-13");
  r.setStatus("Open");

  session.persist(r);

  tx.commit();
  session.close();

  // UPDATE USING HQL
  Session session2 = factory.openSession();
  Transaction tx2 = session2.beginTransaction();

  String hql =
   "update Restaurant set name=:name, status=:status where id=:id";

  MutationQuery query = session2.createMutationQuery(hql);

  query.setParameter("name","Bawarchi");
  query.setParameter("status","Closed");
  query.setParameter("id",1);

  query.executeUpdate();

  tx2.commit();
  session2.close();

  factory.close();

  System.out.println("Record Inserted and Updated Successfully");
 }
}