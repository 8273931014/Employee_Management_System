package employee.management.system;

import com.sun.tools.javac.Main;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {
    Random ran = new Random();
    int number = ran.nextInt(999999);

    JTextField tname, tfname, taddress, tphone, taadhar, temial, tsalary, tdesignation;
    JDateChooser tdob;
    JComboBox Boxeducation;

    JLabel tempid;

    JButton add,back;


    AddEmployee() {
        getContentPane().setBackground(new Color(163, 255, 188));

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel name = new JLabel("Name : ");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        tname = new JTextField();
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

        tdob = new JDateChooser();
        tdob.setBounds(200,200,150,30);
        tdob.setBackground(new Color(177,252,197));
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

        String items[] = {"BBA","B.Tech","BCA","MCA","B.Com","MA","MSC","M.Tech","MBA","PHD"};
        Boxeducation=new JComboBox(items);
        Boxeducation.setBackground(new Color(177,252,197));
        Boxeducation.setBounds(600,300,150,30);
        add(Boxeducation);

        JLabel adhar = new JLabel("Adhar No. : ");
        adhar.setBounds(400, 350, 150, 30);
        adhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(adhar);

        taadhar = new JTextField();
        taadhar.setBounds(600, 350, 150, 30);
        taadhar.setBackground(new Color(177, 252, 197));
        add( taadhar);

        JLabel empid = new JLabel("Employee ID. : ");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add( empid);

        tempid = new JLabel(""+number);
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


        add = new JButton("ADD");
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
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String address = taddress.getText();
            String empID = tempid.getText();
            String salary = tsalary.getText();
            String phone = tphone.getText();
            String email = temial.getText();
            String education = (String) Boxeducation.getSelectedItem();
            String designation = tdesignation.getText();
            String addhar = taadhar.getText();

            try{
                conn c = new conn();
                String query = "insert into employee values ('"+name+"','"+fname+"','"+dob+"','"+salary+"', '"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+addhar+"','"+empID+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added successfully");
                setVisible(false);
                new Main_class();
            }catch(Exception E) {
                E.printStackTrace();
            }

        }
        else {
            new Main_class();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}