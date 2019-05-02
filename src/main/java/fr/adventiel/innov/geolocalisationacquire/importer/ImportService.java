package fr.adventiel.innov.geolocalisationacquire.importer;

/**
 * Import data from Objenious API to our MongoDB database.
 */
interface ImportService {
    /**
     * Main import method.
     */
    void doImport();
}
