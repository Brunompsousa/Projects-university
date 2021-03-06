/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tpraticoid;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abs
 */

public class HttpRequestFunctions {
    
     public static void httpRequestISO(String link,String pesquisa, String outFile){
        URL url;
        try {
            if (!pesquisa.isEmpty()) {
               //System.out.println(link + URLEncoder.encode(pesquisa,"UTF-8"));
               url = new URL(link + URLEncoder.encode(pesquisa,"ISO-8859-1").replace('+', '_')); //alterar replace 
            }
            else{
               //Criar URL simples
               // System.out.println(link);
               url = new URL(link);
            }
            //System.out.println(url);
            URLConnection ligacao = url.openConnection();

            //Ver User-Agent actual de um determinado browser : http://whatsmyuseragent.com
            ligacao.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.6; en-US; rv:1.9.2.16) Gecko/20110319 Firefox/3.6.16");

            BufferedReader in = new BufferedReader(new InputStreamReader(ligacao.getInputStream(), "ISO-8859-1"));
            StringBuilder sb = new StringBuilder();
            String linha;

            while ((linha = in.readLine()) != null) {
                sb.append(linha)
                  .append(System.getProperty("line.separator"));
            }
            //Escrever num ficheiro
            BufferedWriter out = new BufferedWriter(new FileWriter(outFile));
            out.write(sb.toString());
            
            out.close();
            in.close();

        } catch (MalformedURLException ex) {
            Logger.getLogger(HttpRequestFunctions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HttpRequestFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
     
     public static void httpRequestUTF(String link,String pesquisa, String outFile){
        URL url;
        try {
            if (!pesquisa.isEmpty()) {
               //System.out.println(link + URLEncoder.encode(pesquisa,"UTF-8"));
               url = new URL(link + URLEncoder.encode(pesquisa,"UTF-8").replace('+', '_')); //alterar replace 
            }
            else{
               //Criar URL simples
               // System.out.println(link);
               url = new URL(link);
            }
            //System.out.println(url);
            URLConnection ligacao = url.openConnection();

            //Ver User-Agent actual de um determinado browser : http://whatsmyuseragent.com
            ligacao.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.6; en-US; rv:1.9.2.16) Gecko/20110319 Firefox/3.6.16");

            BufferedReader in = new BufferedReader(new InputStreamReader(ligacao.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String linha;

            while ((linha = in.readLine()) != null) {
                sb.append(linha)
                  .append(System.getProperty("line.separator"));
            }
            //Escrever num ficheiro
            BufferedWriter out = new BufferedWriter(new FileWriter(outFile));
            out.write(sb.toString());
            
            out.close();
            in.close();

        } catch (MalformedURLException ex) {
            Logger.getLogger(HttpRequestFunctions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HttpRequestFunctions.class.getName()).log(Level.SEVERE, null, ex);
        } 

    
    }
     
}
