/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.controller;

import com.exam.model.Loan;
import com.exam.util.HibernateUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
@RequestScoped
public class ControllLoan {

    Loan loan = new Loan();

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public void saveLoanReq() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            loan.setStaturs("requst");
            tx = s.beginTransaction();
            s.save(loan);
            tx.commit();
            s.flush();
        } catch (Exception e) {
            tx.rollback();
        }

    }
}
