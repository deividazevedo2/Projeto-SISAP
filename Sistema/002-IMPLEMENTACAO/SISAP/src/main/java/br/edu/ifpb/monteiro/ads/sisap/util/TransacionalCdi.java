package br.edu.ifpb.monteiro.ads.sisap.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.interceptor.InterceptorBinding;

@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
public @interface TransacionalCdi {

}
