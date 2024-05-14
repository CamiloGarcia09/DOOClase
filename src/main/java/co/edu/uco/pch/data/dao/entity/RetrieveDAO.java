package co.edu.uco.pch.data.dao.entity;

import java.util.List;

interface RetrieveDAO <E>{

    // E = Entity
    List<E> consultar(E data);
}
