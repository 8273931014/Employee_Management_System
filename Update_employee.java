package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_employee extends JFrame implements ActionListener  {
    JTextField teducation, tfname, taddress, tphone, taadhar, temial, tsalary, tdesignation;
    JLabel tempid;
    String number;

    JButton add,back;
    Update_employee(String number){
        this.number=number;
        getContentPane().setBackground(new Color(163, 255, 188));

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel name = new JLabel("Name : ");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(200, 150, 150, 30);
        tname.setBackground(new Color(177, 252, 197));
        add(tname);

        JLabel fname = new JLabel("Father's Name : ");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setBackground(new Color(177, 252, 197));
        add(tfname);

        JLabel dob = new JLabel("Date of Birth : ");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);

        JLabel tdob = new JLabel();
        tdob.setBounds(200,200,150,30);
        tdob.setFont(new Font("Tahoma", Font.BOLD,20));
        add(tdob);

        JLabel salary = new JLabel("Salary : ");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        tsalary.setBackground(new Color(177, 252, 197));
        add(tsalary);

        JLabel addre = new JLabel("Address: ");
        addre.setBounds(50, 250, 150, 30);
        addre.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(addre);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        taddress.setBackground(new Color(177, 252, 197));
        add(taddress);

        JLabel phn = new JLabel("Phone no. : ");
        phn.setBounds(400, 250, 150, 30);
        phn.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phn);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        tphone.setBackground(new Color(177, 252, 197));
        add( tphone);


        JLabel em = new JLabel("Email : ");
        em.setBounds(50, 300, 150, 30);
        em.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(em);

        temial = new JTextField();
        temial.setBounds(200, 300, 150, 30);
        temial.setBackground(new Color(177, 252, 197));
        add( temial);

        JLabel hq = new JLabel("Higest Education : ");
        hq.setBounds(400, 300, 150, 30);
        hq.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(hq);

        teducation = new JTextField();
        teducation.setBounds(600, 300, 150, 30);
        teducation.setFont(new Font("SANS_SERIF",Font.BOLD,20));
        teducation.setForeground(Color.RED);
        add( teducation);

        JLabel adhar = new JLabel("Adhar No. : ");
        adhar.setBounds(400, 350, 150, 30);
        adhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(adhar);

        JLabel taadhar = new JLabel();
        taadhar.setBounds(600, 350, 150, 30);
        taadhar.setBackground(new Color(177, 252, 197));
        add( taadhar);

        JLabel empid = new JLabel("Employee ID. : ");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add( empid);

        tempid = new JLabel();
        tempid.setBounds(200, 400, 150, 30);
        tempid.setFont(new Font("SANS_SERIF",Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add( tempid);

        JLabel des = new JLabel("Designation : ");
        des.setBounds(50, 350, 150, 30);
        des.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(des);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        tdesignation.setBackground(new Color(177, 252, 197));
        add( tdesignation);

        try{
            conn c = new conn();
            String query = "select * from employee where empID = '"+number+"'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while(resultSet.next()){
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                taddress.setText(resultSet.getString("address"));
                tsalary.setText(resultSet.getString("salary"));
                tphone.setText(resultSet.getString("phone"));
                temial.setText(resultSet.getString("email"));
                teducation.setText(resultSet.getString("education"));
                tempid.setText(resultSet.getString("empID"));
                tdesignation.setText(resultSet.getString("designation"));
                taadhar.setText(resultSet.getString("adhar"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }


        add = new JButton("UPDATE");
        add.setBounds(450,550,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);


        back = new JButton("BACK");
        back.setBounds(250,550,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);



        setSize(900, 700);
        setLocation(300, 50);
        setLayout(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String fname = tfname.getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temial.getText();
            String education = teducation.getText();
            String designation = tdesignation.getText();

            try{
                conn c = new conn();
                String query = "Update employee set fname = '"+fname+"', salary = '"+salary+"', phone = '"+phone+"',email='"+email+"', address = '"+address+"', education = '"+education+"', designation = '"+designation+"' where empID='"+number+"' ";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details update suncessfully");
                setVisible(false);
                new View_Employee();
            }catch (Exception E){
                E.printStackTrace();
            }
        }
        else {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new Update_employee("");
    }
}
