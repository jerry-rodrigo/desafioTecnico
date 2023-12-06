package com.desafioTecnico.security;

import io.jsonwebtoken.security.Keys;

public class ConstantesSeguridad {
    public static final long JWT_EXPIRATION_TOKEN = 300000; //equivaler a 5 min, donde 60000 = a 1 min
    public static final byte[] JWT_FIRMA = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS512).getEncoded();;
}
