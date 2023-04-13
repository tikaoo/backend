package com.minsait.fintech.serializer;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.minsait.fintech.entity.Emprestimos;

public class EmprestimoIdSerializer extends JsonSerializer<List<Emprestimos>> {
	@Override
    public void serialize(List<Emprestimos> emprestimos, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String emprestimoIds = emprestimos.stream()
                .map(emprestimo -> "IdEmprestimo:" + emprestimo.getIdEmprestimo())
                .collect(Collectors.joining(","));
        jsonGenerator.writeString(emprestimoIds);
    }
}
