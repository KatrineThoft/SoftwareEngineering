grammar PetriNet;

options {
  language = Java;
}

@header {
package parsing;

//import model_check.ast.*;

}

@lexer::header {
package parsing;

}

program returns [PetriNet value]
    : pn=petriNet EOF { $value = pn; }
    ;
    
petriNet returns [PetriNet value]
    : f=petriNetFlows ' ' im=petriNetMarkings { $value = new PetriNet(f, im) }
    ;  
    
petriNetFlows returns [List<Flow> value]
    : { $value = new ArrayList<Flow>(); }
    '.flows' (' ' f=flow { $value.add(f) } )+
    ;

petriNetMarkings returns [List<Markings> value]
    : { $value = new ArrayList<Markings>(); }
    '.initial_marking {' n1=NUM '*' p1=place { $value.add(new Marking(n1, p1)) }
    (', ' n1=NUM '*' p1=place { $value.add(new Marking(n1, p1)) } )* '}'
    ;
    
flow returns [Flow value]
    : t=trans ': {' n1=NUM '*' p1=place '} -> {'n2=NUM '*' p2=place '}' { $value = new Flow(t,p1,p2,n1,n2) }
    ;

trans returns [IDExpr value]
    : ID { $value = new IDExpr(ID)}
    ;
    
place returns [IDExpr value]
    : ID { $value = new IDExpr(ID)}
    ;

NUM 	:	'0'..'9'+;
ID 	:	('a'..'z'|'A'..'Z'|'0'..'9')+;