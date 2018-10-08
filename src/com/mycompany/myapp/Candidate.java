/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.io.Externalizable;
import com.codename1.io.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author wkuan
 */
public class Candidate implements Externalizable{
    private String name;
    private int weight;
    
    public Candidate(){
        this.name = "";
        this.weight = -1;
    }
    
    public Candidate(String name){
        this.name = name;
        this.weight = 1;
    }
    
    public Candidate(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public void externalize(DataOutputStream out) throws IOException {
        Util.writeUTF(name, out);
        Util.writeObject(weight,out);        
    }

    @Override
    public void internalize(int version, DataInputStream in) throws IOException {
        name = Util.readUTF(in);
        weight = (int)Util.readObject(in);
    }

    @Override
    public String getObjectId() {
        return "Candidate";
    }
}
