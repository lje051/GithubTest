package com.choa.s8;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.choa.Board.reply.FreeboardReplyDTO;

@RestController
public class TestRest {
	
	@RequestMapping(value="/replyWrite")
	public ResponseEntity<FreeboardReplyDTO> test(@RequestBody FreeboardReplyDTO freeboardReplyDTO){
		
		System.out.println(freeboardReplyDTO.getRid()); 
		return new ResponseEntity<FreeboardReplyDTO>(freeboardReplyDTO, HttpStatus.OK);
	}
	
	
	
	
	
	
	

}
