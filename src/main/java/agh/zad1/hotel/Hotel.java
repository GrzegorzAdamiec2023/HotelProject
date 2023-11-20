package agh.zad1.hotel;

import agh.zad1.MyMap.MyMap;

public class Hotel {

    private final MyMap<Integer, Boolean> shemat_pokoi = new MyMap<>();
    private final int pietra;
    private final int pokoje;

    private final String pokojNieIstnieje = "Podany pokój nie istnieje, sprobój ponownie.";
    public Hotel(int pietra, int pokoje) throws ZaDuzoPokoiException {
        if(pokoje > 100){
            String pokojeStr = Integer.toString(pokoje);
            throw new ZaDuzoPokoiException("Liczba pokoi jest za duża: " + pokojeStr);
        }
        this.pietra = pietra;
        this.pokoje = pokoje;

        for (int pietro = 0; pietro<pietra; pietro++){
            for (int pokoj = 0; pokoj<pokoje; pokoj++) {
                this.shemat_pokoi.put(pietro * 100 + pokoj, false);
            }
        }
    }
    public String list(){
        StringBuilder out = new StringBuilder();
        for (int pietro = 0; pietro < this.pietra; pietro++){
            int zajete = 0;
            for (int pokoj = 0; pokoj < this.pokoje; pokoj++) {
                if (this.shemat_pokoi.get(pietro * 100 + pokoj)){
                    zajete++;
                }
            }
            out.append("Piętro: ").append(Integer.toString(pietro)).append("\n").append("Liczba pokoi = ")
                    .append(Integer.toString(this.pokoje)).append("\nLiczba wolnych = ")
                    .append(Integer.toString(this.pokoje - zajete)).append("\n\n");
        }
        return out.toString();
    }

    protected boolean is_in_shemat_pokoi(int key){
        return this.shemat_pokoi.keys().contains(key);
    }

    protected boolean is_valid_to_turn_to_int(String key){

        try {
            Integer.parseInt(key);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public String view(String nr_pokoju){
        int key;
        if (!this.is_valid_to_turn_to_int(nr_pokoju)){
            return "Podano złą wartość, sprobój ponownie.";
        }else {
            key = Integer.parseInt(nr_pokoju);
        }

        if (!this.is_in_shemat_pokoi(key)){
            return this.pokojNieIstnieje;
        }




        String out = "Pokój na piętrze: " + nr_pokoju.charAt(0) + " o numerze: " + nr_pokoju.substring(1)
                + "\n status: ";

        if (this.shemat_pokoi.get(key)){
            out += "ZAJĘTY\n";
        }else{
            out += "WOLNY\n";

        }
        return out;
    }

    public String checkin(String nr_pokoju){
        int key;
        if (!this.is_valid_to_turn_to_int(nr_pokoju)){
            return "Podano złą wartość, sprobój ponownie.";
        }else {
            key = Integer.parseInt(nr_pokoju);
        }

        if (!this.is_in_shemat_pokoi(key)){
            return this.pokojNieIstnieje;
        }

        if (this.shemat_pokoi.get(key)){
            return "Pokój nr: " + nr_pokoju + " jest już zajęty.";
        }

        this.shemat_pokoi.remove(key);
        this.shemat_pokoi.put(key, true);
        return "Zajęto pokój.";
    }

    public String checkout(String nr_pokoju) {
        int key;
        if (!this.is_valid_to_turn_to_int(nr_pokoju)){
            return "Podano złą wartosc, sprobój ponownie.";
        }else {
            key = Integer.parseInt(nr_pokoju);
        }

        if (!this.is_in_shemat_pokoi(key)){
            return this.pokojNieIstnieje;
        }

        if (!this.shemat_pokoi.get(key)){
            return "Pokój nr: " + nr_pokoju + " jest wolny.";
        }

        this.shemat_pokoi.remove(key);
        this.shemat_pokoi.put(key, false);
        return "Zwloniono pokój.";
    }



}
