package com.example.javaspringdynamodb.repository;

import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.example.javaspringdynamodb.entity.Funcionario;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class FuncionarioRepository {
	private DynamoDBMapper dynamoDBMapper;

	public Funcionario save(Funcionario funcionario) {
		dynamoDBMapper.save(funcionario);
		return funcionario;
	}

	public Funcionario getFuncionarioById(String funcionarioId) {
		return dynamoDBMapper.load(Funcionario.class, funcionarioId);
	}

	public String delete(String funcionarioId) {
		Funcionario funcionario = dynamoDBMapper.load(Funcionario.class, funcionarioId);
		dynamoDBMapper.delete(funcionario);
		return "Funcionário Deletado!!";
	}

	public String update(String funcionarioId, Funcionario funcionario) {
		dynamoDBMapper.save(funcionario, new DynamoDBSaveExpression().withExpectedEntry("funcionarioId",
				new ExpectedAttributeValue(new AttributeValue().withS(funcionarioId))));
		return funcionarioId;
	}
}