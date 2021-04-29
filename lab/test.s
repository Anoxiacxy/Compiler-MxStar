	.text

	.globl	gcd
	.p2align	2
	.type	gcd,@function
gcd:
.L0_0:
	addi	sp, sp, -272
	sw	ra, 168(sp)
	sw	s11, 96(sp)
	sw	s10, 204(sp)
	sw	s0, 188(sp)
	sw	s1, 256(sp)
	sw	s2, 192(sp)
	sw	s3, 216(sp)
	sw	s4, 180(sp)
	sw	s5, 252(sp)
	sw	s6, 172(sp)
	sw	s7, 224(sp)
	sw	s8, 100(sp)
	sw	s9, 112(sp)
	sw	a0, 156(sp)
	mv	s10, a1
	sw	a2, 232(sp)
	sw	a3, 260(sp)
	mv	s9, a4
	sw	a5, 212(sp)
	sw	a6, 228(sp)
	mv	s3, a7
	lw	s6, 272(sp)
	lw	t4, 276(sp)
	sw	t4, 208(sp)
	lw	s8, 280(sp)
	lw	s2, 284(sp)
	lw	t4, 288(sp)
	sw	t4, 152(sp)
	lw	t4, 292(sp)
	sw	t4, 220(sp)
	lw	t4, 296(sp)
	sw	t4, 136(sp)
	lw	t4, 300(sp)
	sw	t4, 200(sp)
	lw	s5, 304(sp)
	lw	t4, 308(sp)
	sw	t4, 184(sp)
	lw	s7, 312(sp)
	lw	t4, 316(sp)
	sw	t4, 196(sp)
	lw	t4, 320(sp)
	sw	t4, 268(sp)
	lw	t4, 324(sp)
	sw	t4, 264(sp)
	lw	s4, 328(sp)
	lw	t4, 332(sp)
	sw	t4, 148(sp)
	lw	t4, 336(sp)
	sw	t4, 160(sp)
	lw	t4, 340(sp)
	sw	t4, 240(sp)
	lw	t4, 344(sp)
	sw	t4, 116(sp)
	lw	t4, 348(sp)
	sw	t4, 244(sp)
	lw	t4, 352(sp)
	sw	t4, 120(sp)
	lw	t4, 356(sp)
	sw	t4, 132(sp)
	lw	t4, 360(sp)
	sw	t4, 164(sp)
	lw	t4, 364(sp)
	sw	t4, 248(sp)
	addi	a0, zero, 4
	call	malloc
	mv	s0, a0
	addi	a0, zero, 4
	call	malloc
	mv	s1, a0
	addi	a0, zero, 4
	call	malloc
	mv	s11, a0
	sw	zero, 0(s11)
	sw	zero, 0(s1)
	sw	zero, 0(s0)
	lw	t4, 0(s1)
	sw	zero, 0(s1)
	j	.L0_1
.L0_1:
	lw	t4, 0(s1)
	addi	t5, zero, 10
	slt	t4, t5, t4
	xori	t4, t4, 1
	beqz	t4, .L0_4
	j	.L0_2
.L0_2:
	lw	t4, 0(s0)
	lw	t4, 232(sp)
	lw	t5, 260(sp)
	add	t5, t4, t5
	mv	t4, s9
	add	t5, t5, t4
	lw	t4, 212(sp)
	add	t5, t5, t4
	lw	t4, 228(sp)
	add	t5, t5, t4
	mv	t4, s3
	add	t5, t5, t4
	mv	t4, s6
	add	t5, t5, t4
	lw	t4, 208(sp)
	add	t5, t5, t4
	mv	t4, s8
	add	t5, t5, t4
	mv	t4, s2
	add	t5, t5, t4
	lw	t4, 152(sp)
	add	t5, t5, t4
	lw	t4, 220(sp)
	add	t5, t5, t4
	lw	t4, 136(sp)
	add	t5, t5, t4
	lw	t4, 200(sp)
	add	t5, t5, t4
	mv	t4, s5
	add	t5, t5, t4
	lw	t4, 184(sp)
	add	t5, t5, t4
	mv	t4, s7
	add	t5, t5, t4
	lw	t4, 196(sp)
	add	t5, t5, t4
	lw	t4, 268(sp)
	add	t5, t5, t4
	lw	t4, 264(sp)
	add	t5, t5, t4
	mv	t4, s4
	add	t5, t5, t4
	lw	t4, 148(sp)
	add	t5, t5, t4
	lw	t4, 160(sp)
	add	t5, t5, t4
	lw	t4, 240(sp)
	add	t5, t5, t4
	lw	t4, 116(sp)
	add	t5, t5, t4
	lw	t4, 244(sp)
	add	t5, t5, t4
	lw	t4, 120(sp)
	add	t5, t5, t4
	lw	t4, 132(sp)
	add	t5, t5, t4
	lw	t4, 164(sp)
	add	t5, t5, t4
	lw	t4, 248(sp)
	add	t5, t5, t4
	addi	t4, zero, 100
	rem	t4, t5, t4
	sw	t4, 0(s0)
	j	.L0_3
.L0_3:
	lw	t4, 0(s1)
	addi	t4, t4, 1
	sw	t4, 0(s1)
	j	.L0_1
.L0_4:
	lw	t5, 156(sp)
	mv	t4, s10
	rem	t4, t5, t4
	addi	t4, t4, 0
	seqz	t4, t4
	beqz	t4, .L0_7
	j	.L0_5
.L0_5:
	mv	t4, s10
	sw	t4, 0(s11)
	j	.L0_10
.L0_6:
	j	.L0_9
.L0_7:
	mv	t4, s10
	sw	t4, 128(sp)
	lw	t5, 156(sp)
	mv	t4, s10
	rem	t4, t5, t4
	sw	t4, 124(sp)
	lw	t4, 0(s0)
	sw	t4, 104(sp)
	addi	a0, zero, 10
	addi	a1, zero, 68
	mv	a2, zero
	addi	a3, zero, 2
	addi	a4, zero, 4
	addi	a5, zero, 6
	addi	a6, zero, 8
	addi	a7, zero, 10
	addi	t4, zero, 12
	sw	t4, 0(sp)
	addi	t4, zero, 14
	sw	t4, 4(sp)
	addi	t4, zero, 16
	sw	t4, 8(sp)
	addi	t4, zero, 18
	sw	t4, 12(sp)
	addi	t4, zero, 20
	sw	t4, 16(sp)
	addi	t4, zero, 22
	sw	t4, 20(sp)
	addi	t4, zero, 24
	sw	t4, 24(sp)
	addi	t4, zero, 26
	sw	t4, 28(sp)
	addi	t4, zero, 28
	sw	t4, 32(sp)
	addi	t4, zero, 30
	sw	t4, 36(sp)
	addi	t4, zero, 32
	sw	t4, 40(sp)
	addi	t4, zero, 34
	sw	t4, 44(sp)
	addi	t4, zero, 36
	sw	t4, 48(sp)
	addi	t4, zero, 38
	sw	t4, 52(sp)
	addi	t4, zero, 40
	sw	t4, 56(sp)
	addi	t4, zero, 42
	sw	t4, 60(sp)
	addi	t4, zero, 44
	sw	t4, 64(sp)
	addi	t4, zero, 46
	sw	t4, 68(sp)
	addi	t4, zero, 48
	sw	t4, 72(sp)
	addi	t4, zero, 50
	sw	t4, 76(sp)
	addi	t4, zero, 52
	sw	t4, 80(sp)
	addi	t4, zero, 54
	sw	t4, 84(sp)
	addi	t4, zero, 56
	sw	t4, 88(sp)
	addi	t4, zero, 58
	sw	t4, 92(sp)
	call	gcd
	mv	a3, a0
	mv	a4, s9
	lw	t4, 212(sp)
	mv	a5, t4
	lw	t4, 228(sp)
	mv	a6, t4
	mv	a7, s3
	mv	t4, s6
	sw	t4, 144(sp)
	lw	t4, 208(sp)
	sw	t4, 236(sp)
	mv	t4, s8
	sw	t4, 108(sp)
	mv	t4, s2
	sw	t4, 140(sp)
	lw	t4, 152(sp)
	sw	t4, 176(sp)
	lw	t4, 220(sp)
	mv	s8, t4
	lw	t4, 136(sp)
	mv	ra, t4
	lw	t4, 200(sp)
	mv	s9, t4
	mv	t4, s5
	lw	t5, 184(sp)
	mv	t0, t5
	mv	t5, s7
	lw	t6, 196(sp)
	mv	t1, t6
	lw	t6, 268(sp)
	mv	t2, t6
	lw	t6, 264(sp)
	mv	t3, t6
	mv	t6, s4
	lw	a0, 148(sp)
	mv	s5, a0
	lw	a0, 160(sp)
	mv	s3, a0
	lw	a0, 240(sp)
	mv	s6, a0
	lw	a0, 116(sp)
	mv	s1, a0
	lw	a0, 244(sp)
	mv	s7, a0
	lw	a0, 120(sp)
	mv	s0, a0
	lw	a0, 132(sp)
	mv	s2, a0
	lw	a0, 164(sp)
	mv	s4, a0
	lw	a0, 248(sp)
	mv	s10, a0
	lw	a0, 128(sp)
	lw	a1, 124(sp)
	lw	a2, 104(sp)
	lw	a0, 144(sp)
	sw	a0, 0(sp)
	lw	a0, 236(sp)
	sw	a0, 4(sp)
	lw	a0, 108(sp)
	sw	a0, 8(sp)
	lw	a0, 140(sp)
	sw	a0, 12(sp)
	lw	a0, 176(sp)
	sw	a0, 16(sp)
	sw	s8, 20(sp)
	sw	ra, 24(sp)
	sw	s9, 28(sp)
	sw	t4, 32(sp)
	sw	t0, 36(sp)
	sw	t5, 40(sp)
	sw	t1, 44(sp)
	sw	t2, 48(sp)
	sw	t3, 52(sp)
	sw	t6, 56(sp)
	sw	s5, 60(sp)
	sw	s3, 64(sp)
	sw	s6, 68(sp)
	sw	s1, 72(sp)
	sw	s7, 76(sp)
	sw	s0, 80(sp)
	sw	s2, 84(sp)
	sw	s4, 88(sp)
	sw	s10, 92(sp)
	call	gcd1
	sw	a0, 0(s11)
	j	.L0_10
.L0_8:
	j	.L0_9
.L0_9:
	j	.L0_10
.L0_10:
	lw	a0, 0(s11)
	lw	s11, 96(sp)
	lw	s10, 204(sp)
	lw	s0, 188(sp)
	lw	s1, 256(sp)
	lw	s2, 192(sp)
	lw	s3, 216(sp)
	lw	s4, 180(sp)
	lw	s5, 252(sp)
	lw	s6, 172(sp)
	lw	s7, 224(sp)
	lw	s8, 100(sp)
	lw	s9, 112(sp)
	lw	ra, 168(sp)
	addi	sp, sp, 272
	ret
	.size	gcd, .-gcd
	.globl	gcd1
	.p2align	2
	.type	gcd1,@function
gcd1:
.L1_0:
	addi	sp, sp, -268
	sw	ra, 224(sp)
	sw	s11, 212(sp)
	sw	s10, 180(sp)
	sw	s0, 216(sp)
	sw	s1, 204(sp)
	sw	s2, 172(sp)
	sw	s3, 100(sp)
	sw	s4, 228(sp)
	sw	s5, 184(sp)
	sw	s6, 248(sp)
	sw	s7, 164(sp)
	sw	s8, 156(sp)
	sw	s9, 168(sp)
	sw	a0, 176(sp)
	mv	s0, a1
	sw	a2, 128(sp)
	mv	s3, a3
	sw	a4, 124(sp)
	sw	a5, 144(sp)
	mv	s7, a6
	sw	a7, 188(sp)
	lw	s1, 268(sp)
	lw	t4, 272(sp)
	sw	t4, 136(sp)
	lw	s6, 276(sp)
	lw	t4, 280(sp)
	sw	t4, 232(sp)
	lw	s4, 284(sp)
	lw	t4, 288(sp)
	sw	t4, 140(sp)
	lw	t4, 292(sp)
	sw	t4, 244(sp)
	lw	t4, 296(sp)
	sw	t4, 200(sp)
	lw	t4, 300(sp)
	sw	t4, 220(sp)
	lw	s5, 304(sp)
	lw	t4, 308(sp)
	sw	t4, 120(sp)
	lw	s9, 312(sp)
	lw	s2, 316(sp)
	lw	s8, 320(sp)
	lw	t4, 324(sp)
	sw	t4, 132(sp)
	lw	t4, 328(sp)
	sw	t4, 116(sp)
	lw	t4, 332(sp)
	sw	t4, 160(sp)
	lw	t4, 336(sp)
	sw	t4, 148(sp)
	lw	t4, 340(sp)
	sw	t4, 252(sp)
	lw	t4, 344(sp)
	sw	t4, 152(sp)
	lw	t4, 348(sp)
	sw	t4, 196(sp)
	lw	t4, 352(sp)
	sw	t4, 240(sp)
	lw	t4, 356(sp)
	sw	t4, 208(sp)
	lw	t4, 360(sp)
	sw	t4, 112(sp)
	addi	a0, zero, 4
	call	malloc
	mv	s10, a0
	addi	a0, zero, 4
	call	malloc
	mv	s11, a0
	sw	zero, 0(s11)
	sw	zero, 0(s10)
	lw	t4, 0(s10)
	lw	t5, 128(sp)
	mv	t4, s3
	add	t5, t5, t4
	lw	t4, 124(sp)
	add	t5, t5, t4
	lw	t4, 144(sp)
	add	t5, t5, t4
	mv	t4, s7
	add	t5, t5, t4
	lw	t4, 188(sp)
	add	t5, t5, t4
	mv	t4, s1
	add	t5, t5, t4
	lw	t4, 136(sp)
	add	t5, t5, t4
	mv	t4, s6
	add	t5, t5, t4
	lw	t4, 232(sp)
	add	t5, t5, t4
	mv	t4, s4
	add	t5, t5, t4
	lw	t4, 140(sp)
	add	t5, t5, t4
	lw	t4, 244(sp)
	add	t5, t5, t4
	lw	t4, 200(sp)
	add	t5, t5, t4
	lw	t4, 220(sp)
	add	t5, t5, t4
	mv	t4, s5
	add	t5, t5, t4
	lw	t4, 120(sp)
	add	t5, t5, t4
	mv	t4, s9
	add	t5, t5, t4
	mv	t4, s2
	add	t5, t5, t4
	mv	t4, s8
	add	t5, t5, t4
	lw	t4, 132(sp)
	add	t5, t5, t4
	lw	t4, 116(sp)
	add	t5, t5, t4
	lw	t4, 160(sp)
	add	t5, t5, t4
	lw	t4, 148(sp)
	add	t5, t5, t4
	lw	t4, 252(sp)
	add	t5, t5, t4
	lw	t4, 152(sp)
	add	t5, t5, t4
	lw	t4, 196(sp)
	add	t5, t5, t4
	lw	t4, 240(sp)
	add	t5, t5, t4
	lw	t4, 208(sp)
	add	t5, t5, t4
	lw	t4, 112(sp)
	add	t5, t5, t4
	addi	t4, zero, 100
	rem	t4, t5, t4
	sw	t4, 0(s10)
	lw	t5, 176(sp)
	mv	t4, s0
	rem	t4, t5, t4
	addi	t4, t4, 0
	seqz	t4, t4
	beqz	t4, .L1_3
	j	.L1_1
.L1_1:
	mv	t4, s0
	sw	t4, 0(s11)
	j	.L1_6
.L1_2:
	j	.L1_5
.L1_3:
	mv	a0, s0
	lw	t5, 176(sp)
	mv	t4, s0
	rem	a1, t5, t4
	lw	a2, 0(s10)
	mv	a3, s3
	lw	t4, 124(sp)
	mv	a4, t4
	lw	t4, 144(sp)
	mv	a5, t4
	mv	a6, s7
	lw	t4, 188(sp)
	sw	t4, 260(sp)
	mv	t4, s1
	sw	t4, 96(sp)
	lw	t4, 136(sp)
	sw	t4, 108(sp)
	mv	t4, s6
	sw	t4, 104(sp)
	lw	t4, 232(sp)
	sw	t4, 192(sp)
	mv	t4, s4
	sw	t4, 236(sp)
	lw	t4, 140(sp)
	sw	t4, 264(sp)
	lw	t4, 244(sp)
	mv	s7, t4
	lw	t4, 200(sp)
	sw	t4, 256(sp)
	lw	t4, 220(sp)
	mv	s6, t4
	mv	t4, s5
	lw	t5, 120(sp)
	mv	t0, t5
	mv	t5, s9
	mv	t6, s2
	mv	ra, s8
	lw	a7, 132(sp)
	mv	t1, a7
	lw	a7, 116(sp)
	mv	t3, a7
	lw	a7, 160(sp)
	mv	s5, a7
	lw	a7, 148(sp)
	mv	s1, a7
	lw	a7, 252(sp)
	mv	s3, a7
	lw	a7, 152(sp)
	mv	t2, a7
	lw	a7, 196(sp)
	mv	s2, a7
	lw	a7, 240(sp)
	mv	s4, a7
	lw	a7, 208(sp)
	mv	s0, a7
	lw	a7, 112(sp)
	mv	s10, a7
	lw	a7, 260(sp)
	lw	a0, 96(sp)
	sw	a0, 0(sp)
	lw	a0, 108(sp)
	sw	a0, 4(sp)
	lw	a0, 104(sp)
	sw	a0, 8(sp)
	lw	a0, 192(sp)
	sw	a0, 12(sp)
	lw	a0, 236(sp)
	sw	a0, 16(sp)
	lw	a0, 264(sp)
	sw	a0, 20(sp)
	sw	s7, 24(sp)
	lw	a0, 256(sp)
	sw	a0, 28(sp)
	sw	s6, 32(sp)
	sw	t4, 36(sp)
	sw	t0, 40(sp)
	sw	t5, 44(sp)
	sw	t6, 48(sp)
	sw	ra, 52(sp)
	sw	t1, 56(sp)
	sw	t3, 60(sp)
	sw	s5, 64(sp)
	sw	s1, 68(sp)
	sw	s3, 72(sp)
	sw	t2, 76(sp)
	sw	s2, 80(sp)
	sw	s4, 84(sp)
	sw	s0, 88(sp)
	sw	s10, 92(sp)
	call	gcd2
	sw	a0, 0(s11)
	j	.L1_6
.L1_4:
	j	.L1_5
.L1_5:
	j	.L1_6
.L1_6:
	lw	a0, 0(s11)
	lw	s11, 212(sp)
	lw	s10, 180(sp)
	lw	s0, 216(sp)
	lw	s1, 204(sp)
	lw	s2, 172(sp)
	lw	s3, 100(sp)
	lw	s4, 228(sp)
	lw	s5, 184(sp)
	lw	s6, 248(sp)
	lw	s7, 164(sp)
	lw	s8, 156(sp)
	lw	s9, 168(sp)
	lw	ra, 224(sp)
	addi	sp, sp, 268
	ret
	.size	gcd1, .-gcd1
	.globl	gcd2
	.p2align	2
	.type	gcd2,@function
gcd2:
.L2_0:
	addi	sp, sp, -256
	sw	ra, 148(sp)
	sw	s11, 136(sp)
	sw	s10, 224(sp)
	sw	s0, 240(sp)
	sw	s1, 164(sp)
	sw	s2, 116(sp)
	sw	s3, 180(sp)
	sw	s4, 192(sp)
	sw	s5, 120(sp)
	sw	s6, 108(sp)
	sw	s7, 228(sp)
	sw	s8, 200(sp)
	sw	s9, 232(sp)
	mv	s2, a0
	mv	s10, a1
	mv	s5, a2
	sw	a3, 244(sp)
	sw	a4, 144(sp)
	sw	a5, 248(sp)
	mv	s3, a6
	mv	s1, a7
	lw	s6, 256(sp)
	lw	s0, 260(sp)
	lw	t4, 264(sp)
	sw	t4, 188(sp)
	lw	t4, 268(sp)
	sw	t4, 216(sp)
	lw	t4, 272(sp)
	sw	t4, 100(sp)
	lw	t4, 276(sp)
	sw	t4, 160(sp)
	lw	t4, 280(sp)
	sw	t4, 168(sp)
	lw	t4, 284(sp)
	sw	t4, 176(sp)
	lw	s7, 288(sp)
	lw	s9, 292(sp)
	lw	t4, 296(sp)
	sw	t4, 140(sp)
	lw	s4, 300(sp)
	lw	t4, 304(sp)
	sw	t4, 152(sp)
	lw	t4, 308(sp)
	sw	t4, 236(sp)
	lw	s8, 312(sp)
	lw	t4, 316(sp)
	sw	t4, 184(sp)
	lw	t4, 320(sp)
	sw	t4, 208(sp)
	lw	t4, 324(sp)
	sw	t4, 212(sp)
	lw	t4, 328(sp)
	sw	t4, 196(sp)
	lw	t4, 332(sp)
	sw	t4, 172(sp)
	lw	t4, 336(sp)
	sw	t4, 124(sp)
	lw	t4, 340(sp)
	sw	t4, 156(sp)
	lw	t4, 344(sp)
	sw	t4, 104(sp)
	lw	t4, 348(sp)
	sw	t4, 220(sp)
	addi	a0, zero, 4
	call	malloc
	mv	s11, a0
	sw	zero, 0(s11)
	addi	t4, zero, 0
	mv	t4, s5
	lw	t5, 244(sp)
	add	t5, t4, t5
	lw	t4, 144(sp)
	add	t5, t5, t4
	lw	t4, 248(sp)
	add	t5, t5, t4
	mv	t4, s3
	add	t5, t5, t4
	mv	t4, s1
	add	t5, t5, t4
	mv	t4, s6
	add	t5, t5, t4
	mv	t4, s0
	add	t5, t5, t4
	lw	t4, 188(sp)
	add	t5, t5, t4
	lw	t4, 216(sp)
	add	t5, t5, t4
	lw	t4, 100(sp)
	add	t5, t5, t4
	lw	t4, 160(sp)
	add	t5, t5, t4
	lw	t4, 168(sp)
	add	t5, t5, t4
	lw	t4, 176(sp)
	add	t5, t5, t4
	mv	t4, s7
	add	t5, t5, t4
	mv	t4, s9
	add	t5, t5, t4
	lw	t4, 140(sp)
	add	t5, t5, t4
	mv	t4, s4
	add	t5, t5, t4
	lw	t4, 152(sp)
	add	t5, t5, t4
	lw	t4, 236(sp)
	add	t5, t5, t4
	mv	t4, s8
	add	t5, t5, t4
	lw	t4, 184(sp)
	add	t5, t5, t4
	lw	t4, 208(sp)
	add	t5, t5, t4
	lw	t4, 212(sp)
	add	t5, t5, t4
	lw	t4, 196(sp)
	add	t5, t5, t4
	lw	t4, 172(sp)
	add	t5, t5, t4
	lw	t4, 124(sp)
	add	t5, t5, t4
	lw	t4, 156(sp)
	add	t5, t5, t4
	lw	t4, 104(sp)
	add	t5, t5, t4
	lw	t4, 220(sp)
	add	t4, t5, t4
	addi	t5, zero, 100
	rem	t4, t4, t5
	mv	t5, s2
	mv	t4, s10
	rem	t4, t5, t4
	addi	t4, t4, 0
	seqz	t4, t4
	beqz	t4, .L2_3
	j	.L2_1
.L2_1:
	mv	t4, s10
	sw	t4, 0(s11)
	j	.L2_6
.L2_2:
	j	.L2_5
.L2_3:
	mv	a0, s10
	mv	t4, s2
	mv	t5, s10
	rem	a1, t4, t5
	mv	a2, s5
	lw	a3, 244(sp)
	lw	a4, 144(sp)
	lw	a5, 248(sp)
	mv	a6, s3
	mv	a7, s1
	mv	t4, s6
	sw	t4, 132(sp)
	mv	t4, s0
	sw	t4, 128(sp)
	lw	t4, 188(sp)
	sw	t4, 112(sp)
	lw	t4, 216(sp)
	sw	t4, 204(sp)
	lw	t4, 100(sp)
	sw	t4, 252(sp)
	lw	t4, 160(sp)
	sw	t4, 96(sp)
	lw	t0, 168(sp)
	lw	t2, 176(sp)
	mv	t4, s7
	mv	t5, s9
	lw	t1, 140(sp)
	mv	t6, s4
	lw	s0, 152(sp)
	lw	s3, 236(sp)
	mv	ra, s8
	lw	s4, 184(sp)
	lw	s1, 208(sp)
	lw	t3, 212(sp)
	lw	s5, 196(sp)
	lw	s10, 172(sp)
	lw	s7, 124(sp)
	lw	s6, 156(sp)
	lw	s2, 104(sp)
	lw	s8, 220(sp)
	lw	a0, 132(sp)
	sw	a0, 0(sp)
	lw	a0, 128(sp)
	sw	a0, 4(sp)
	lw	a0, 112(sp)
	sw	a0, 8(sp)
	lw	a0, 204(sp)
	sw	a0, 12(sp)
	lw	a0, 252(sp)
	sw	a0, 16(sp)
	lw	a0, 96(sp)
	sw	a0, 20(sp)
	sw	t0, 24(sp)
	sw	t2, 28(sp)
	sw	t4, 32(sp)
	sw	t5, 36(sp)
	sw	t1, 40(sp)
	sw	t6, 44(sp)
	sw	s0, 48(sp)
	sw	s3, 52(sp)
	sw	ra, 56(sp)
	sw	s4, 60(sp)
	sw	s1, 64(sp)
	sw	t3, 68(sp)
	sw	s5, 72(sp)
	sw	s10, 76(sp)
	sw	s7, 80(sp)
	sw	s6, 84(sp)
	sw	s2, 88(sp)
	sw	s8, 92(sp)
	call	gcd
	sw	a0, 0(s11)
	j	.L2_6
.L2_4:
	j	.L2_5
.L2_5:
	j	.L2_6
.L2_6:
	lw	a0, 0(s11)
	lw	s11, 136(sp)
	lw	s10, 224(sp)
	lw	s0, 240(sp)
	lw	s1, 164(sp)
	lw	s2, 116(sp)
	lw	s3, 180(sp)
	lw	s4, 192(sp)
	lw	s5, 120(sp)
	lw	s6, 108(sp)
	lw	s7, 228(sp)
	lw	s8, 200(sp)
	lw	s9, 232(sp)
	lw	ra, 148(sp)
	addi	sp, sp, 256
	ret
	.size	gcd2, .-gcd2
	.globl	main
	.p2align	2
	.type	main,@function
main:
.L3_0:
	addi	sp, sp, -104
	sw	ra, 96(sp)
	sw	s11, 100(sp)
	call	mx__init
	addi	a0, zero, 4
	call	malloc
	mv	s11, a0
	sw	zero, 0(s11)
	addi	a0, zero, 10
	addi	a1, zero, 1
	mv	a2, zero
	addi	a3, zero, 2
	addi	a4, zero, 4
	addi	a5, zero, 6
	addi	a6, zero, 8
	addi	a7, zero, 10
	addi	t4, zero, 12
	sw	t4, 0(sp)
	addi	t4, zero, 14
	sw	t4, 4(sp)
	addi	t4, zero, 16
	sw	t4, 8(sp)
	addi	t4, zero, 18
	sw	t4, 12(sp)
	addi	t4, zero, 20
	sw	t4, 16(sp)
	addi	t4, zero, 22
	sw	t4, 20(sp)
	addi	t4, zero, 24
	sw	t4, 24(sp)
	addi	t4, zero, 26
	sw	t4, 28(sp)
	addi	t4, zero, 28
	sw	t4, 32(sp)
	addi	t4, zero, 30
	sw	t4, 36(sp)
	addi	t4, zero, 32
	sw	t4, 40(sp)
	addi	t4, zero, 34
	sw	t4, 44(sp)
	addi	t4, zero, 36
	sw	t4, 48(sp)
	addi	t4, zero, 38
	sw	t4, 52(sp)
	addi	t4, zero, 40
	sw	t4, 56(sp)
	addi	t4, zero, 42
	sw	t4, 60(sp)
	addi	t4, zero, 44
	sw	t4, 64(sp)
	addi	t4, zero, 46
	sw	t4, 68(sp)
	addi	t4, zero, 48
	sw	t4, 72(sp)
	addi	t4, zero, 50
	sw	t4, 76(sp)
	addi	t4, zero, 52
	sw	t4, 80(sp)
	addi	t4, zero, 54
	sw	t4, 84(sp)
	addi	t4, zero, 56
	sw	t4, 88(sp)
	addi	t4, zero, 58
	sw	t4, 92(sp)
	call	gcd
	addi	a0, a0, 1024
	call	mx__toString
	call	mx__println
	sw	zero, 0(s11)
	j	.L3_2
.L3_1:
	j	.L3_2
.L3_2:
	lw	a0, 0(s11)
	lw	s11, 100(sp)
	lw	ra, 96(sp)
	addi	sp, sp, 104
	ret
	.size	main, .-main
	.globl	mx__init
	.p2align	2
	.type	mx__init,@function
mx__init:
.L4_0:
	j	.L4_1
.L4_1:
	ret
	.size	mx__init, .-mx__init

	.section	.sdata,"aw",@progbits
