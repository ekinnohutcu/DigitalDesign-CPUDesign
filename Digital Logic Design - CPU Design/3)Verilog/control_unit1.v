module control_unit(ins,clk,aluchoice, alu_enable, ready, comp_enable, read_enable, pc_enable, st, pc_select, we, ram_enable, mem_load, imm_enable);

input [17:0] ins;
input clk;
input [1:0] aluchoice;
output alu_enable, ready, comp_enable, read_enable, pc_enable, st, pc_select, we, ram_enable, mem_load, imm_enable;

wire [3:0] reg1,reg2,dst;
wire [3:0] opcode;
wire [2:0] bchoice;
wire [13:0] add14b;
wire [9:0] add10b;
wire [5:0] imm;

assign add10b = ins[9:0];
assign imm = ins[5:0];
assign add14b = ins[13:0];
assign reg1 = ins[5:2];
assign reg2 = ins[9:6];
assign dst = ins[13:10];
assign opcode = ins[17:14];
assign bchoice = ins[16:14];


reg[4:0] selection_decoder;
reg decoder_out;

reg and1,or1,add1,xor1,addi,andi,ori,xori,beq,bgt,blt,bge,ble,ld,st,jump,fetch1,fetch2,ld2,st2;
always @(posedge clk)
begin



case(selection_decoder)
5'b00000: assign decoder_out = and1;
5'b00001: assign decoder_out = or1;
5'b00010: assign decoder_out = add1;
5'b00011: assign decoder_out = xor1;
5'b00100: assign decoder_out = andi;
5'b00101: assign decoder_out = ori;
5'b00110: assign decoder_out = addi;
5'b00111: assign decoder_out = xori;
5'b01000: assign decoder_out = beq;
5'b01001: assign decoder_out = bgt;
5'b01010: assign decoder_out = blt;
5'b01011: assign decoder_out = bge;
5'b01100: assign decoder_out = ble;
5'b01101: assign decoder_out = ld;
5'b01110: assign decoder_out = st;
5'b01111: assign decoder_out = jump;
5'b10000: assign decoder_out = fetch1;
5'b10001: assign decoder_out = fetch2;
5'b10010: assign decoder_out = ld2;
5'b10011: assign decoder_out = st2;
endcase



end
endmodule
