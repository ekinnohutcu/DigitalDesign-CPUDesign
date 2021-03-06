
module adder1 #(parameter N=17)(A, B, Ci, S, Co);
  
  input [N:0] A,B;
  input Ci;
  output [N:0] S;
  reg [N:0] S;
  output Co;
  reg Co;
  
  reg [N+1:0] A1,B1,S1;
  always @(A, B, Ci) begin
    A1= {1'b0, A}; B1= {1'b0, B};
    S1= A1 + B1 + Ci;
    S <= S1[N:0];
    Co <= S1[N+1];
  end
endmodule