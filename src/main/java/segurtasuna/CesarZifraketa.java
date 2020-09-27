package segurtasuna;

public class CesarZifraketa {
    private char[] gakoaSortu(int desp){
        //Desplazamendua emanda, alfabetoko letrak x posizio desplazatu egiten ditu
        //Aurre: desp positiboa izan behar da
        //Post: Gakoa Array batean itzuliko du alfabetoa desplazatuz.

        char gakoa[] = new char[26];
        int zenbat = desp%26;
        for(int i=zenbat; i < zenbat+26; i++){
            int letra = 65+i;

            if(letra > 90){
                letra = letra-26;
            }
            gakoa[i-zenbat] = (char)letra;
        }
        return gakoa;
    }

    public String zifratu(String mezua, int desp){
        //Mezu bat emanda, cesar zifraketa erabiliz kriptograma sortuko du
        //Aurre: Mezuak ezin izago ditu karaktere bereziak izan.
        //      Alfabetoa: abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ
        //Post: Mezua enkriptatuta itzultzen du

        System.out.println("Emandako mezua:\n" + mezua + "\n");
        System.out.println("Mezua zifratzen...");
        char patroia[];

        patroia = this.gakoaSortu(desp);

        System.out.println("Desplazamendua: " + desp%26 + " karaktere");
        for(int j = 0; j < 26; j++){ //Patroia inprimatu
            System.out.print(patroia[j]);
        }
        System.out.println(" \n");

        String mezuaPrest = "";
        mezuaPrest = this.hutsuneakKendu(mezua);
        mezuaPrest = this.letraLarrizJarri(mezuaPrest);

        String kriptograma = "";
        for(int i = 0 ; i < mezuaPrest.length(); i++){
            int ascii = (int)mezuaPrest.charAt(i);
            int pos = ascii - 65; //Patroian dagokion posizioa kalkulatu
            kriptograma = kriptograma+patroia[pos];
        }

        System.out.println("Kriptograma:\n"+kriptograma+"\n");
        return kriptograma;
    }


    private String hutsuneakKendu(String mezua){
        //Mezu bat emanda hutsuneak kentzen dizkio
        //Post: Hutsune gabeko String bat itzultzen du

        return mezua.replace(" ","");
    }


    private String letraLarrizJarri(String mezua){
        //Mezu bat emanda letra larriz jartzen du
        //Post: Bakarrik letra larriak dituen String bat itzultzen du

        return mezua.toUpperCase();
    }

    public String deszifratu(String kriptograma, int desp){
        //Kriptograma eta desplazamendua emanda, mezu argia lortzen du
        //Aurre: Kriptogramak eta ditu karaktere berezirik izan eta desplazamendua positiboa izan behar da
        //Post: Kriptogramari dagokion mezua lortu da

        System.out.println("Mezua deszifratzen...");

        String mezua = "";
        desp = desp%26;

        kriptograma=this.hutsuneakKendu(kriptograma);
        kriptograma=this.letraLarrizJarri(kriptograma);

        for(int i = 0 ; i < kriptograma.length(); i++){
            int ascii = (int)kriptograma.charAt(i)-desp;
            if(ascii < 65){
               ascii = ascii + 26;
            }
            char letra = (char)(ascii);
            mezua = mezua+letra;
        }
        System.out.println("Mezu argia:\n"+mezua+"\n");


        return mezua;
    }
}
