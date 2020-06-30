package com.alisdlyc.hotel.utils;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author 14287
 */
public class InstructionUtils {
    private String ins;
    private HashMap<String, LinkedList<String>> insMap;
    private LinkedList<String> insArgs;
    private HashMap<String, String> argsType;

    public InstructionUtils() {
        ins = null;
        insMap = new HashMap<String, LinkedList<String>>();
        insArgs = new LinkedList<String>();
        argsType = new HashMap<String, String>();
        init();
    }

    public void init() {
        ins = "create";
        insArgs.add("username");
        insArgs.add("password");
        addInstruction(ins, insArgs);
        insArgs.clear();

        ins = "login";
        insArgs.add("username");
        insArgs.add("password");
        addInstruction(ins, insArgs);
        insArgs.clear();

        ins = "logout";
        addInstruction(ins, null);


        ins = "delete";
        insArgs.add("admin");
        insArgs.add("username");
        addInstruction(ins, insArgs);
        insArgs.clear();

        ins = "addroom";
        insArgs.add("roomnumber");
        addInstruction(ins, insArgs);
        insArgs.clear();

        ins = "reserve_room";
        insArgs.add("people_number");
        insArgs.add("startdate");
        insArgs.add("enddate");
        addInstruction(ins, insArgs);
        insArgs.clear();

        ins = "show_reservations";
        addInstruction(ins, null);

        ins = "show_reservation";
        addInstruction(ins, null);

        argsType.put("username", "String");
        argsType.put("password", "String");
        argsType.put("admin", "String");
        argsType.put("roomnumber", "int");
        argsType.put("people_number", "int");
        argsType.put("startdate", "String");
        argsType.put("enddate", "String");
    }

    public void addInstruction(String ins, LinkedList<String> args) {
        insMap.put(ins, args);
    }

    public String getIns() {
        return ins;
    }

    public void setIns(String ins) {
        this.ins = ins;
    }

    public HashMap<String, LinkedList<String>> getInsMap() {
        return insMap;
    }

    public void setInsMap(HashMap<String, LinkedList<String>> insMap) {
        this.insMap = insMap;
    }

    public LinkedList<String> getInsArgs() {
        return insArgs;
    }

    public void setInsArgs(LinkedList<String> insArgs) {
        this.insArgs = insArgs;
    }

    public HashMap<String, String> getArgsType() {
        return argsType;
    }

    public void setArgsType(HashMap<String, String> argsType) {
        this.argsType = argsType;
    }

    @Override
    public String toString() {
        return "InstructionUtils{" +
                "ins='" + ins + '\'' +
                ", insMap=" + insMap +
                ", insArgs=" + insArgs +
                ", argsType=" + argsType +
                '}';
    }
}
