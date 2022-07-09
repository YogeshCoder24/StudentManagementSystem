package com.weekenddevelopers.studentmanagementsystem.model;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;


public class StudentDB implements Serializable {


    private String _id, name, dob, department, CGPA, mail;
    private int year, __v;
    private long phone, register_no;

    //constructors

    public StudentDB(String name, String dob, String department, String CGPA, String mail, int year, long phone, long register_no) {
        this.name = name;
        this.dob = dob;
        this.department = department;
        this.CGPA = CGPA;
        this.mail = mail;
        this.year = year;
        this.phone = phone;
        this.register_no = register_no;
    }

    public StudentDB(String _id, String name, String dob, String department, String CGPA, String mail, int year, int __v, long phone, long register_no) {
        this._id = _id;
        this.name = name;
        this.dob = dob;
        this.department = department;
        this.CGPA = CGPA;
        this.mail = mail;
        this.year = year;
        this.__v = __v;
        this.phone = phone;
        this.register_no = register_no;
    }

    public StudentDB() {
    }

//    protected StudentDB(Parcel in) {
//        _id = in.readString();
//        name = in.readString();
//        dob = in.readString();
//        department = in.readString();
//        CGPA = in.readString();
//        mail = in.readString();
//        year = in.readInt();
//        __v = in.readInt();
//        phone = in.readLong();
//        register_no = in.readLong();
//    }
//
//    public static final Creator<StudentDB> CREATOR = new Creator<StudentDB>() {
//        @Override
//        public StudentDB createFromParcel(Parcel in) {
//            return new StudentDB(in);
//        }
//
//        @Override
//        public StudentDB[] newArray(int size) {
//            return new StudentDB[size];
//        }
//    };

    //getter and setters
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCGPA() {
        return CGPA;
    }

    public void setCGPA(String CGPA) {
        this.CGPA = CGPA;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public long getRegister_no() {
        return register_no;
    }

    public void setRegister_no(long register_no) {
        this.register_no = register_no;
    }

//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel parcel, int i) {
//        parcel.writeString(_id);
//        parcel.writeString(name);
//        parcel.writeString(dob);
//        parcel.writeString(department);
//        parcel.writeString(CGPA);
//        parcel.writeString(mail);
//        parcel.writeInt(year);
//        parcel.writeInt(__v);
//        parcel.writeLong(phone);
//        parcel.writeLong(register_no);
//    }
}
