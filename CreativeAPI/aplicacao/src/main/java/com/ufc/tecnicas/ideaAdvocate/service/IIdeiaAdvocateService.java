package com.ufc.tecnicas.ideaAdvocate.service;

import java.util.List;

import com.ufc.tecnicas.ideaAdvocate.model.AdvocateIdeia;
import com.ufc.tecnicas.ideaAdvocate.model.AdvocateAvaliacao;
import com.ufc.tecnicas.ideaAdvocate.model.AdvocateComentario;
import com.ufc.tecnicas.ideaAdvocate.model.IdeiaAdvocate;
import com.ufc.tecnicas.model.Pessoa;

public interface IIdeiaAdvocateService {

	void criarAdvocate(IdeiaAdvocate advocate);

	List<IdeiaAdvocate> buscarAdvocatesPorPessoa(Pessoa pessoa);

	void adicionarParticipante(Pessoa pessoa, IdeiaAdvocate advocate);

	void adicionarIdeia(AdvocateIdeia ideia, IdeiaAdvocate advocate);

	void adicionarComentario(AdvocateComentario comentario, AdvocateIdeia ideia);

	void adicionarAvaliacao(AdvocateAvaliacao avaliacao, AdvocateIdeia ideia);
}
