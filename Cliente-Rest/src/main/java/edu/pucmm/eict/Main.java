package edu.pucmm.eict;

import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("\nUsuario: ");
        String username = in.nextLine();
        System.out.println("Contraseña: ");
        String password = in.nextLine();

        //Listado de URLS
        HttpResponse listadoURLS = Unirest.get("http://localhost:7000/rest/url/?username=" + username +"&password=" + password)
                .header("accept", "application/json")
                .asObject(new GenericType<List<ServiciosRetorno>>() {
                });
        System.out.println("\nListado de URLs");
        System.out.println("HTTP Status: " + listadoURLS.getStatus());
        System.out.println("HTTP Message: " + listadoURLS.getBody().toString());


        //Registrar (Acortar) una URL
        System.out.println("URL Original que desea acortar: ");
        String url = in.nextLine();
        RestRequest req = new RestRequest(username, url);
        JSONObject aux = new JSONObject();
        aux.put("user", req.user);
        aux.put("url", req.url);
        HttpResponse shortenURL = Unirest.post("http://localhost:7000/rest/url/?username=" + username +"&password=" + password)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(aux)
                .asJson();
        System.out.println("\nURL Acortada: ");
        System.out.println("HTTP Status: " + shortenURL.getStatus());
        System.out.println("HTTP Message: " + shortenURL.getBody().toString());

    }

    static class RestRequest {
        private String user;
        private String url;

        public RestRequest(String user, String url) {
            this.user = user;
            this.url = url;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }


    static class ServiciosRetorno {
        private String urloriginal;
        private String urlcorta;
        private Date fechaRegistro;
        private String fechaString;
        private long visitasSafari;
        private long visitasOpera;
        private long visitasChrome;
        private long visitasEdge;
        private long visitasFirefox;
        private long visitaswindows;
        private long visitasubuntu;
        private long visitasandroid;
        private String previewIMG;

        public String getUrloriginal() {
            return urloriginal;
        }

        public void setUrloriginal(String urloriginal) {
            this.urloriginal = urloriginal;
        }

        public String getUrlcorta() {
            return urlcorta;
        }

        public void setUrlcorta(String urlcorta) {
            this.urlcorta = urlcorta;
        }

        public Date getFechaRegistro() {
            return fechaRegistro;
        }

        public void setFechaRegistro(Date fechaRegistro) {
            this.fechaRegistro = fechaRegistro;
        }

        public String getFechaString() {
            return fechaString;
        }

        public void setFechaString(String fechaString) {
            this.fechaString = fechaString;
        }

        public long getVisitasSafari() {
            return visitasSafari;
        }

        public void setVisitasSafari(long visitasSafari) {
            this.visitasSafari = visitasSafari;
        }

        public long getVisitasOpera() {
            return visitasOpera;
        }

        public void setVisitasOpera(long visitasOpera) {
            this.visitasOpera = visitasOpera;
        }

        public long getVisitasChrome() {
            return visitasChrome;
        }

        public void setVisitasChrome(long visitasChrome) {
            this.visitasChrome = visitasChrome;
        }

        public long getVisitasEdge() {
            return visitasEdge;
        }

        public void setVisitasEdge(long visitasEdge) {
            this.visitasEdge = visitasEdge;
        }

        public long getVisitasFirefox() {
            return visitasFirefox;
        }

        public void setVisitasFirefox(long visitasFirefox) {
            this.visitasFirefox = visitasFirefox;
        }

        public long getVisitaswindows() {
            return visitaswindows;
        }

        public void setVisitaswindows(long visitaswindows) {
            this.visitaswindows = visitaswindows;
        }

        public long getVisitasubuntu() {
            return visitasubuntu;
        }

        public void setVisitasubuntu(long visitasubuntu) {
            this.visitasubuntu = visitasubuntu;
        }

        public long getVisitasandroid() {
            return visitasandroid;
        }

        public void setVisitasandroid(long visitasandroid) {
            this.visitasandroid = visitasandroid;
        }

        public String getPreviewIMG() {
            return previewIMG;
        }

        public void setPreviewIMG(String previewIMG) {
            this.previewIMG = previewIMG;
        }
    }


}