package com.ivanchez.videogamesapi;

import java.util.*;

public class Data {
    private HashMap<String, Console> consoles;

    public Data() {
        consoles = new HashMap<String, Console>();
        initializeConsoles();
    }

    private void initializeConsoles() {
        Console console = new Console("Wii", "Nintendo", 2006);
        consoles.put(console.getId(), console);
        console = new Console("Xbox 360", "Microsoft", 2005);
        consoles.put(console.getId(), console);
        console = new Console("PlayStation 3", "Sony", 2006);
        consoles.put(console.getId(), console);
    }

    public List<Console> getConsoles(String company, String year) {
        ArrayList<Console> consolesByQuery = new ArrayList<Console>(consoles.values());
        if(company != null) {
            ArrayList<Console> consolesByCompany = new ArrayList<Console>();
            for(Console c : consoles.values()) {
                if(c.getCompany().equals(company)) {
                    consolesByCompany.add(c);
                }
            }
            consolesByQuery.retainAll(consolesByCompany);
        }
        if(year != null) {
            ArrayList<Console> consolesByYear = new ArrayList<Console>();
            for(Console c : consoles.values()) {
                if(c.getYear() == Integer.parseInt(year)) {
                    consolesByYear.add(c);
                }
            }
            consolesByQuery.retainAll(consolesByYear);
        }
        return consolesByQuery;
    }

    public void addConsole(Console console) {
        consoles.put(console.getId(), console);
    }

    public boolean deleteConsole(String id) {
        return consoles.remove(id) != null;
    }

    public boolean updateConsole(String id, Console console) {
        if(consoles.containsKey(id)) {
            Console c = consoles.get(id);
            if(console.getName() != null) {
                c.setName(console.getName());
            }
            if(console.getCompany() != null) {
                c.setCompany(console.getCompany());
            }
            if(console.getYear() > 0) {
                c.setYear(console.getYear());
            }
            return true;
        }
        return false;
    }

    public Console getConsole(String id) {
        return consoles.get(id);
    }
}
