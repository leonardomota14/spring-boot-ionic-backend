package com.leonardomota.cursomc.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leonardomota.cursomc.domain.Cidade;
import com.leonardomota.cursomc.domain.Estado;
import com.leonardomota.cursomc.dto.CidadeDTO;
import com.leonardomota.cursomc.dto.EstadoDTO;
import com.leonardomota.cursomc.services.CidadeService;
import com.leonardomota.cursomc.services.EstadoService;

@RestController
@RequestMapping(value="/estados")
public class EstadoResource {
	
	@Autowired
	private EstadoService service;
	
	@Autowired
	private CidadeService cidadeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EstadoDTO>> findAllByOrderByNome() {
		List<Estado> list = service.findAllByOrderByNome();
		List<EstadoDTO> listDto = list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{estadoId}/cidades", method=RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer estadoId) {
		List<Cidade> list = cidadeService.findByEstado(estadoId);
		List<CidadeDTO> listDto = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
/*	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<EstadoDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Estado> pageList = service.findPage(page, linesPerPage, orderBy, direction);
		Page<EstadoDTO> pageListDto = pageList.map(obj -> new EstadoDTO(obj));
		return ResponseEntity.ok().body(pageListDto);
	}
*/
}
