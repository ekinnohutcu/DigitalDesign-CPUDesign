module pc_selector1(input1, input2, b_choice, enable, out);

input [17:0] input1,input2;
input [2:0] b_choice;
input enable;

output out;
reg out;

reg zf,pf,nf;

always @(input1,input2,b_choice,enable) 
begin

if(input1 == input2)
begin
zf <= 1;
pf <= 0;
nf <= 0;
end

 if(input1 < input2)
begin 
nf <= 1;
pf <= 0;
zf <= 0;
end

 if(input1 > input2)
begin
pf <= 1;
zf <= 0;
nf <= 0;
end


if(enable == 0)
begin
assign out= 0;
end

 if(enable == 1)
begin

	case(b_choice)
	3'b000: assign out = zf;
	3'b001: assign out = pf;
	3'b010: assign out = nf; 
	3'b011: assign out = pf | zf;
	3'b100: assign out = nf | zf;
	endcase

end


end

endmodule