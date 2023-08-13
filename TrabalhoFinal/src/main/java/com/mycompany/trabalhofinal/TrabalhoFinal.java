package com.mycompany.trabalhofinal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Stack;

import javax.swing.JOptionPane;

public class TrabalhoFinal {

    public static ArrayList<Transportadora> tranporlist = new ArrayList();
    public static ArrayList<Transportadora> cargafchada = new ArrayList();
    public static Stack<Transportadora> pila = new Stack();

    public static void main(String[] args) {
        JframeTrabalho a = new JframeTrabalho();
        a.setVisible(true);
    }
    // Cadastra Na Primera Array
    // Esta es la primera parte del trabajo donde tenes que registrar las crags
    public Object Cadastro(String nomeEnvio, String nomeDestino, float Volume, float distancia) {

        tranporlist.add(new Transportadora(nomeEnvio, nomeDestino, Volume, distancia));
        return null;

    }
    //muestra Array de los productos de arriba
    public String ObteCastro() {
        String st1 = "";

        for (Transportadora t : tranporlist) {

            for (int i = 0; i < tranporlist.size(); i++) {
                int y = 0;
                y++;

                st1 += i + ")Cliente Remitente " + tranporlist.get(i).getNomeRemetente() + "\n" + "Nome do destinatarip "
                        + tranporlist.get(i).getNomeClienteDestino() + "\n"
                        + "Volume carga " + tranporlist.get(i).getVolumeCarga()
                        + "\n" + "Distancia da carga " + tranporlist.get(i).getDistancaoCidadeDestino() + "\n";

            }
            return "" + st1;
        }

        return null;
    }
    //Fecha La carga y pasa los productos para otreo array
    //pasa los producots que tienen el volumen de la carga menos que 50
    
    public String FecharCarga() throws IOException {
        float total = 50;
        Transportadora tt = new Transportadora();
        float acu = 0;
        for (int i = 0; i < tranporlist.size();) { //depesito

            if (acu + tranporlist.get(i).getVolumeCarga() <= total) {
                acu = acu + tranporlist.get(i).getVolumeCarga();
                cargafchada.add(tranporlist.get(i));
                
               tranporlist.remove(i);

            } else {
               // acu = acu + tranporlist.get(i).getVolumeCarga();
              //  cargafchada.add(tranporlist.get(i));        //caminhao
              i++;
                // tranporlist.remove(i);
            }

            File arquivo = new File("Cargasfechadas.csv");
            FileWriter fw = new FileWriter(arquivo, false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Transportadora l : cargafchada) {
                bw.write(l.getNomeRemetente() + ";");
                bw.write(l.getNomeClienteDestino() + ";");
                bw.write(l.getVolumeCarga() + ";");
                bw.write(l.getDistancaoCidadeDestino() + ";");
                bw.newLine();
            }
            bw.close();
            fw.close();
        }
        ///s
              

        /// Muetra la lista que en el camion
        String st1 = "";
        float precio = 1.17f;
        float totall = 0;

        for (Transportadora t : cargafchada) {

            for (int i = 0; i < cargafchada.size(); i++) {
                int y = 0;
                y++;

                st1 += ")Cliente Remitente " + cargafchada.get(i).getNomeRemetente() + "\n" + "Nome do destinatarip "
                        + cargafchada.get(i).getNomeClienteDestino() + "\n"
                        + "Volume carga " + cargafchada.get(i).getVolumeCarga()
                        + "\n" + "Distancia da carga " + cargafchada.get(i).getDistancaoCidadeDestino() + "\n";
                totall += cargafchada.get(i).getVolumeCarga()*  precio * cargafchada.get(i).getDistancaoCidadeDestino();
            }
                    

            JOptionPane.showMessageDialog(null, st1 + "\n" + "Volume todal " + acu + "\n" + "Valor carga " + totall);
            // cargafchada.clear();
            return "" + st1;
        }
        return null;
    }
    //Grava o primero array no archivo csv
    public String GrabarAchivo() throws IOException {
        File arquivo = new File("CargasRecebidas.csv");
        FileWriter fw = new FileWriter(arquivo, false);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Transportadora l : tranporlist) {
            bw.write(l.getNomeRemetente() + ";");
            bw.write(l.getNomeClienteDestino() + ";");
            bw.write(l.getVolumeCarga() + ";");
            bw.write(l.getDistancaoCidadeDestino() + ";");
            //Valor do metro³ = Cubagem * R$ 1,17 * km
            

            bw.newLine();
        }
        bw.close();
        fw.close();
        return null;
    }

    //Muestra Pila final de la segunda parte del proyecto
    public String exebirPila() {
        String st1 = "";

        for (Transportadora t : pila) {

            for (int i = 0; i < pila.size(); i++) {
                int y = 0;
                y++;

                st1 += i + ")Cliente Remitente " + pila.get(i).getNomeRemetente() + "\n" + "Nome do destinatarip "
                        + pila.get(i).getNomeClienteDestino() + "\n"
                        + "Volume carga " + pila.get(i).getVolumeCarga()
                        + "\n" + "Distancia da carga " + pila.get(i).getDistancaoCidadeDestino() + "\n";
                
            }
            
            return "" + st1;

        }
        return "Todas cargas fueron Descargadas";
    }
    //Saca las cargas por distancia
    
    public String DesemPilar(float distancia) {
        //pila.peek().getDistancaoCidadeDestino();
        for (int i = 0; i < pila.size(); i++) {
            if (pila.peek().getDistancaoCidadeDestino() == distancia) {
                pila.pop();

            }
            else return "Todas cargas fueron carregads";

        }
        return null;

    }
    //Grava el array de cuando fecha camion en achivo text
    
    public float GravaArchivoParaPila() throws IOException {
        File arquivo = new File("archivoParaPilas.txt");
        FileWriter fw = new FileWriter(arquivo, false);
        BufferedWriter bw = new BufferedWriter(fw);
        float distancia = 400;
        for (Transportadora l : cargafchada) {
            if (l.getDistancaoCidadeDestino() == distancia) {

                bw.write(l.getNomeRemetente() + ";");
                bw.write(l.getNomeClienteDestino() + ";");
                bw.write(l.getVolumeCarga() + ";");
                bw.write(l.getDistancaoCidadeDestino() + ";");
                bw.newLine();
            }
        }

        distancia = 340;
        for (Transportadora l : cargafchada) {
            if (l.getDistancaoCidadeDestino() == distancia) {

                bw.write(l.getNomeRemetente() + ";");
                bw.write(l.getNomeClienteDestino() + ";");
                bw.write(l.getVolumeCarga() + ";");
                bw.write(l.getDistancaoCidadeDestino() + ";");
                bw.newLine();
            }
        }

        distancia = 180;
        for (Transportadora l : cargafchada) {
            if (l.getDistancaoCidadeDestino() == distancia) {

                bw.write(l.getNomeRemetente() + ";");
                bw.write(l.getNomeClienteDestino() + ";");
                bw.write(l.getVolumeCarga() + ";");
                bw.write(l.getDistancaoCidadeDestino() + ";");
                bw.newLine();
            }
        }
        bw.close();
        fw.close();

        return 0;

    }
    //lee achivo y pasa para pila en orden descrecnte
    
    public float LeePila() throws IOException {
        File arquivo = new File("archivoParaPilas.txt");
        FileReader fr = new FileReader(arquivo);
        BufferedReader br = new BufferedReader(fr);
        while (br.ready()) {
            String[] t = br.readLine().split(";");

            String nome = t[0];
            String nome2 = t[1];
            float volume = Float.parseFloat(t[2]);
            float distancia = Float.parseFloat(t[3]);

            pila.push(new Transportadora(nome, nome2, volume, distancia));
        }
        fr.close();
        return 0;

    }
    

}
