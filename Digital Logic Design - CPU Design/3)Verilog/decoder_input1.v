module decoder_input1(fetch1, fetch2, ld1, st1, clr, clk, input1, out);

input fetch1, fetch2, ld1, st1, clr, clk;
input [4:0] input1;

output [4:0] out;
reg out;

always @(posedge clk)

begin

if(clr == 1)
begin
assign out = 10000;
end

if(fetch1 == 1)
begin
assign out = 10001;
end

if(fetch2 == 1)
begin
assign out = input1;
end

if(ld1 == 1)
begin 
assign out = 10010;
end

if(st1 == 1)
begin
assign out = 10011;
end

else
begin
assign out = 10000;
end


end
endmodule