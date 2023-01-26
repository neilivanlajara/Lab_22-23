interface Poligono{
    // è per forza public, altrimenti non fa niente 

    double getPerimetro();

    int getFacce();

    boolean regolare();

    default double getLato() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("non è regolare");
    } // significa che è opzionale 
}