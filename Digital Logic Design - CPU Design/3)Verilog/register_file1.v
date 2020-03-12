module register_file1(rd1,rd2,wr,we,input1,clk,reset,out1,out2);

input [3:0] rd1,rd2;
input [3:0] wr;
input we,clk,reset;
input [17:0] input1;

output [17:0] out1,out2;

reg[17:0] r0,r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15;


always @(posedge clk)
begin

if(we == 1)
begin
case(wr)
4'b0000: assign r0 = input1;
4'b0001: assign r1 = input1;
4'b0010: assign r2 = input1;
4'b0011: assign r3= input1;
4'b0100: assign r4 = input1;
4'b0101: assign r5 = input1;
4'b0110: assign r6 = input1;
4'b0111: assign r7 = input1;
4'b1000: assign r8 = input1;
4'b1001: assign r9 = input1;
4'b1010: assign r10 = input1;
4'b1011: assign r11 = input1;
4'b1100: assign r12 = input1;
4'b1101: assign r13 = input1;
4'b1110: assign r14 = input1;
4'b1111:  assign r15 = input1;
endcase
end

case(rd1)
4'b0000:  out1 <= r0;
4'b0001:  out1  <= r1;
4'b0010: out1 <= r2;
4'b0011:  out1 <= r3;
4'b0100:  out1  <= r4;
4'b0101: out1  <= r5;
4'b0110: out1  <= r6;
4'b0111: out1  <= r7;
4'b1000: out1  <= r8;
4'b1001: out1  <= r9;
4'b1010: out1  <= r10;
4'b1011: out1  <= r11;
4'b1100: out1  <= r12;
4'b1101: out1  <= r13;
4'b1110: out1  <= r14;
4'b1111: out1  <= r15;
endcase

case(rd2)
4'b0000:  out2 <= r0;
4'b0001:  out2  <= r1;
4'b0010:  out2 <= r2;
4'b0011:  out2 <= r3;
4'b0100:  out2  <= r4;
4'b0101:  out2  <= r5;
4'b0110:  out2  <= r6;
4'b0111:  out2  <= r7;
4'b1000:  out2  <= r8;
4'b1001:  out2  <= r9;
4'b1010:  out2  <= r10;
4'b1011:  out2  <= r11;
4'b1100:  out2  <= r12;
4'b1101:  out2  <= r13;
4'b1110:  out2  <= r14;
4'b1111:  out2  <= r15;
endcase

end
endmodule