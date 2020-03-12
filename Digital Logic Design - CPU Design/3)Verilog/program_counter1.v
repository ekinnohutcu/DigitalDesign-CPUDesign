module program_counter1(constant,jump_ad,b_insad,pc_select,bins_bit,pc_read,ready,clk,reset,out);

input [13:0] jump_ad,b_insad;
input pc_select,bins_bit,ready,clk,reset,pc_read;
input constant;

output [13:0] out;
reg [13:0] out;

reg[13:0] mux_out1;
reg [13:0] mux_out2;

reg [13:0] adder_out1;

reg[13:0] register1;
reg [13:0] register2;

assign constant = 1;


initial begin
register1 = 13'b0000000000000;
register2 = 13'b0000000000000;
end

always @(jump_ad,constant, posedge clk)
begin
if(bins_bit == 0)
begin 
assign mux_out1 = 1;
end

if(bins_bit == 1)
begin
assign mux_out1 = b_insad;
end

assign adder_out1 = mux_out1 + register1;

if(pc_select == 0)
begin
assign mux_out2 = adder_out1;
end

if(pc_select == 1)
begin
assign mux_out2 = jump_ad;
end

if(ready == 1 && clk == 1)
begin
assign register1 = mux_out2;
end

if(pc_read == 1 && clk == 1)
begin 
assign register2 = register1;
assign out = register2;
end




end



endmodule


