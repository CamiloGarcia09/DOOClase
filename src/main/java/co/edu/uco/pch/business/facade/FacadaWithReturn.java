package co.edu.uco.pch.business.facade;

public interface FacadaWithReturn <T, K> {

    K execute (T dto);

}
