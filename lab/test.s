	.text

	.globl	gcd
	.p2align	2
	.type	gcd,@function
gcd:
.L0_0:
	addi	sp, sp, -364
	sw	ra, 348(sp)
	sw	s11, 308(sp)
	sw	s10, 240(sp)
	sw	s0, 276(sp)
	sw	s1, 152(sp)
	sw	s2, 312(sp)
	sw	s3, 260(sp)
	sw	s4, 140(sp)
	sw	s5, 144(sp)
	sw	s6, 188(sp)
	sw	s7, 176(sp)
	sw	s8, 120(sp)
	sw	s9, 280(sp)
	mv	s11, a0
	mv	s7, a1
	mv	s1, a2
	mv	s6, a3
	mv	s10, a4
	mv	s3, a5
	mv	s5, a6
	mv	s8, a7
	lw	s2, 364(sp)
	lw	s0, 368(sp)
	lw	t4, 372(sp)
	sw	t4, 264(sp)
	lw	t4, 376(sp)
	sw	t4, 252(sp)
	lw	t4, 380(sp)
	sw	t4, 340(sp)
	lw	t4, 384(sp)
	sw	t4, 148(sp)
	lw	t4, 388(sp)
	sw	t4, 208(sp)
	lw	t4, 392(sp)
	sw	t4, 160(sp)
	lw	t4, 396(sp)
	sw	t4, 268(sp)
	lw	t4, 400(sp)
	sw	t4, 112(sp)
	lw	t4, 404(sp)
	sw	t4, 296(sp)
	lw	t4, 408(sp)
	sw	t4, 284(sp)
	lw	t4, 412(sp)
	sw	t4, 116(sp)
	lw	t4, 416(sp)
	sw	t4, 168(sp)
	lw	t4, 420(sp)
	sw	t4, 212(sp)
	lw	t4, 424(sp)
	sw	t4, 128(sp)
	lw	t4, 428(sp)
	sw	t4, 236(sp)
	lw	t4, 432(sp)
	sw	t4, 344(sp)
	lw	t4, 436(sp)
	sw	t4, 156(sp)
	lw	t4, 440(sp)
	sw	t4, 100(sp)
	lw	t4, 444(sp)
	sw	t4, 164(sp)
	lw	t4, 448(sp)
	sw	t4, 184(sp)
	lw	t4, 452(sp)
	sw	t4, 196(sp)
	lw	t4, 456(sp)
	sw	t4, 132(sp)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 328(sp)
	addi	a0, zero, 4
	call	malloc
	mv	s4, a0
	addi	a0, zero, 4
	call	malloc
	sw	a0, 172(sp)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 228(sp)
	lw	t4, 228(sp)
	sw	s11, 0(t4)
	addi	a0, zero, 4
	call	malloc
	mv	s11, a0
	sw	s7, 0(s11)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 232(sp)
	lw	t4, 232(sp)
	sw	s1, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 224(sp)
	lw	t4, 224(sp)
	sw	s6, 0(t4)
	addi	a0, zero, 4
	call	malloc
	mv	s1, a0
	sw	s10, 0(s1)
	addi	a0, zero, 4
	call	malloc
	mv	s10, a0
	sw	s3, 0(s10)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 192(sp)
	lw	t4, 192(sp)
	sw	s5, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 304(sp)
	lw	t4, 304(sp)
	sw	s8, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 288(sp)
	lw	t4, 288(sp)
	sw	s2, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 104(sp)
	lw	t4, 104(sp)
	sw	s0, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 216(sp)
	lw	t5, 216(sp)
	lw	t4, 264(sp)
	sw	t4, 0(t5)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 336(sp)
	lw	t4, 252(sp)
	lw	t5, 336(sp)
	sw	t4, 0(t5)
	addi	a0, zero, 4
	call	malloc
	mv	s2, a0
	lw	t4, 340(sp)
	sw	t4, 0(s2)
	addi	a0, zero, 4
	call	malloc
	mv	s7, a0
	lw	t4, 148(sp)
	sw	t4, 0(s7)
	addi	a0, zero, 4
	call	malloc
	mv	s8, a0
	lw	t4, 208(sp)
	sw	t4, 0(s8)
	addi	a0, zero, 4
	call	malloc
	mv	s9, a0
	lw	t4, 160(sp)
	sw	t4, 0(s9)
	addi	a0, zero, 4
	call	malloc
	mv	s0, a0
	lw	t4, 268(sp)
	sw	t4, 0(s0)
	addi	a0, zero, 4
	call	malloc
	mv	s3, a0
	lw	t4, 112(sp)
	sw	t4, 0(s3)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 324(sp)
	lw	t4, 296(sp)
	lw	t5, 324(sp)
	sw	t4, 0(t5)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 332(sp)
	lw	t5, 284(sp)
	lw	t4, 332(sp)
	sw	t5, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 248(sp)
	lw	t5, 116(sp)
	lw	t4, 248(sp)
	sw	t5, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 108(sp)
	lw	t5, 108(sp)
	lw	t4, 168(sp)
	sw	t4, 0(t5)
	addi	a0, zero, 4
	call	malloc
	mv	s5, a0
	lw	t4, 212(sp)
	sw	t4, 0(s5)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 204(sp)
	lw	t5, 128(sp)
	lw	t4, 204(sp)
	sw	t5, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 96(sp)
	lw	t4, 96(sp)
	lw	t5, 236(sp)
	sw	t5, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 352(sp)
	lw	t5, 344(sp)
	lw	t4, 352(sp)
	sw	t5, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 180(sp)
	lw	t5, 156(sp)
	lw	t4, 180(sp)
	sw	t5, 0(t4)
	addi	a0, zero, 4
	call	malloc
	mv	s6, a0
	lw	t4, 100(sp)
	sw	t4, 0(s6)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 244(sp)
	lw	t5, 164(sp)
	lw	t4, 244(sp)
	sw	t5, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 272(sp)
	lw	t4, 184(sp)
	lw	t5, 272(sp)
	sw	t4, 0(t5)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 220(sp)
	lw	t4, 196(sp)
	lw	t5, 220(sp)
	sw	t4, 0(t5)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 300(sp)
	lw	t5, 132(sp)
	lw	t4, 300(sp)
	sw	t5, 0(t4)
	lw	t4, 0(s4)
	sw	zero, 0(s4)
	j	.L0_1
.L0_1:
	lw	t5, 0(s4)
	addi	t4, zero, 10
	slt	t4, t4, t5
	xori	t4, t4, 1
	beqz	t4, .L0_4
	j	.L0_2
.L0_2:
	lw	t4, 328(sp)
	lw	t4, 0(t4)
	lw	t4, 232(sp)
	lw	t5, 0(t4)
	lw	t4, 224(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 0(s1)
	add	t4, t5, t4
	lw	t5, 0(s10)
	add	t5, t4, t5
	lw	t4, 192(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 304(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 288(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 104(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 216(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 336(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 0(s2)
	add	t5, t5, t4
	lw	t4, 0(s7)
	add	t5, t5, t4
	lw	t4, 0(s8)
	add	t4, t5, t4
	lw	t5, 0(s9)
	add	t4, t4, t5
	lw	t5, 0(s0)
	add	t4, t4, t5
	lw	t5, 0(s3)
	add	t5, t4, t5
	lw	t4, 324(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 332(sp)
	lw	t4, 0(t4)
	add	t4, t5, t4
	lw	t5, 248(sp)
	lw	t5, 0(t5)
	add	t5, t4, t5
	lw	t4, 108(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 0(s5)
	add	t5, t5, t4
	lw	t4, 204(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 96(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 352(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 180(sp)
	lw	t4, 0(t4)
	add	t4, t5, t4
	lw	t5, 0(s6)
	add	t5, t4, t5
	lw	t4, 244(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 272(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 220(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 300(sp)
	lw	t4, 0(t4)
	add	t4, t5, t4
	addi	t5, zero, 100
	rem	t5, t4, t5
	lw	t4, 328(sp)
	sw	t5, 0(t4)
	j	.L0_3
.L0_3:
	lw	t4, 0(s4)
	addi	t4, t4, 1
	sw	t4, 0(s4)
	j	.L0_1
.L0_4:
	lw	t4, 228(sp)
	lw	t4, 0(t4)
	lw	t5, 0(s11)
	rem	t4, t4, t5
	addi	t4, t4, 0
	seqz	t4, t4
	beqz	t4, .L0_7
	j	.L0_5
.L0_5:
	lw	t5, 0(s11)
	lw	t4, 172(sp)
	sw	t5, 0(t4)
	j	.L0_10
.L0_6:
	j	.L0_9
.L0_7:
	lw	t4, 0(s11)
	sw	t4, 292(sp)
	lw	t4, 228(sp)
	lw	t5, 0(t4)
	lw	t4, 0(s11)
	rem	t4, t5, t4
	sw	t4, 136(sp)
	lw	t4, 328(sp)
	lw	t4, 0(t4)
	sw	t4, 256(sp)
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
	lw	a4, 0(s1)
	lw	a5, 0(s10)
	lw	t4, 192(sp)
	lw	a6, 0(t4)
	lw	t4, 304(sp)
	lw	a7, 0(t4)
	lw	t4, 288(sp)
	lw	t4, 0(t4)
	sw	t4, 320(sp)
	lw	t4, 104(sp)
	lw	t4, 0(t4)
	sw	t4, 316(sp)
	lw	t4, 216(sp)
	lw	t4, 0(t4)
	sw	t4, 200(sp)
	lw	t4, 336(sp)
	lw	t4, 0(t4)
	sw	t4, 124(sp)
	lw	t4, 0(s2)
	sw	t4, 356(sp)
	lw	t4, 0(s7)
	sw	t4, 360(sp)
	lw	s7, 0(s8)
	lw	t4, 0(s9)
	lw	t5, 0(s0)
	lw	t1, 0(s3)
	lw	t6, 324(sp)
	lw	t2, 0(t6)
	lw	t6, 332(sp)
	lw	ra, 0(t6)
	lw	t6, 248(sp)
	lw	t0, 0(t6)
	lw	t6, 108(sp)
	lw	t6, 0(t6)
	lw	t3, 0(s5)
	lw	a0, 204(sp)
	lw	s11, 0(a0)
	lw	a0, 96(sp)
	lw	s10, 0(a0)
	lw	a0, 352(sp)
	lw	s1, 0(a0)
	lw	a0, 180(sp)
	lw	s0, 0(a0)
	lw	s5, 0(s6)
	lw	a0, 244(sp)
	lw	s3, 0(a0)
	lw	a0, 272(sp)
	lw	s6, 0(a0)
	lw	a0, 220(sp)
	lw	s4, 0(a0)
	lw	a0, 300(sp)
	lw	s2, 0(a0)
	lw	a0, 292(sp)
	lw	a1, 136(sp)
	lw	a2, 256(sp)
	lw	a0, 320(sp)
	sw	a0, 0(sp)
	lw	a0, 316(sp)
	sw	a0, 4(sp)
	lw	a0, 200(sp)
	sw	a0, 8(sp)
	lw	a0, 124(sp)
	sw	a0, 12(sp)
	lw	a0, 356(sp)
	sw	a0, 16(sp)
	lw	a0, 360(sp)
	sw	a0, 20(sp)
	sw	s7, 24(sp)
	sw	t4, 28(sp)
	sw	t5, 32(sp)
	sw	t1, 36(sp)
	sw	t2, 40(sp)
	sw	ra, 44(sp)
	sw	t0, 48(sp)
	sw	t6, 52(sp)
	sw	t3, 56(sp)
	sw	s11, 60(sp)
	sw	s10, 64(sp)
	sw	s1, 68(sp)
	sw	s0, 72(sp)
	sw	s5, 76(sp)
	sw	s3, 80(sp)
	sw	s6, 84(sp)
	sw	s4, 88(sp)
	sw	s2, 92(sp)
	call	gcd1
	lw	t4, 172(sp)
	sw	a0, 0(t4)
	j	.L0_10
.L0_8:
	j	.L0_9
.L0_9:
	j	.L0_10
.L0_10:
	lw	t4, 172(sp)
	lw	a0, 0(t4)
	lw	s11, 308(sp)
	lw	s10, 240(sp)
	lw	s0, 276(sp)
	lw	s1, 152(sp)
	lw	s2, 312(sp)
	lw	s3, 260(sp)
	lw	s4, 140(sp)
	lw	s5, 144(sp)
	lw	s6, 188(sp)
	lw	s7, 176(sp)
	lw	s8, 120(sp)
	lw	s9, 280(sp)
	lw	ra, 348(sp)
	addi	sp, sp, 364
	ret
	.size	gcd, .-gcd
	.globl	gcd1
	.p2align	2
	.type	gcd1,@function
gcd1:
.L1_0:
	addi	sp, sp, -340
	sw	ra, 108(sp)
	sw	s11, 148(sp)
	sw	s10, 240(sp)
	sw	s0, 184(sp)
	sw	s1, 140(sp)
	sw	s2, 280(sp)
	sw	s3, 320(sp)
	sw	s4, 168(sp)
	sw	s5, 216(sp)
	sw	s6, 292(sp)
	sw	s7, 172(sp)
	sw	s8, 264(sp)
	sw	s9, 300(sp)
	mv	s3, a0
	mv	s1, a1
	mv	s11, a2
	mv	s10, a3
	mv	s7, a4
	mv	s6, a5
	mv	s2, a6
	mv	s4, a7
	lw	s0, 340(sp)
	lw	s5, 344(sp)
	lw	s8, 348(sp)
	lw	s9, 352(sp)
	lw	t4, 356(sp)
	sw	t4, 200(sp)
	lw	t4, 360(sp)
	sw	t4, 104(sp)
	lw	t4, 364(sp)
	sw	t4, 272(sp)
	lw	t4, 368(sp)
	sw	t4, 276(sp)
	lw	t4, 372(sp)
	sw	t4, 180(sp)
	lw	t4, 376(sp)
	sw	t4, 152(sp)
	lw	t4, 380(sp)
	sw	t4, 296(sp)
	lw	t4, 384(sp)
	sw	t4, 136(sp)
	lw	t4, 388(sp)
	sw	t4, 220(sp)
	lw	t4, 392(sp)
	sw	t4, 112(sp)
	lw	t4, 396(sp)
	sw	t4, 124(sp)
	lw	t4, 400(sp)
	sw	t4, 204(sp)
	lw	t4, 404(sp)
	sw	t4, 176(sp)
	lw	t4, 408(sp)
	sw	t4, 260(sp)
	lw	t4, 412(sp)
	sw	t4, 160(sp)
	lw	t4, 416(sp)
	sw	t4, 316(sp)
	lw	t4, 420(sp)
	sw	t4, 164(sp)
	lw	t4, 424(sp)
	sw	t4, 324(sp)
	lw	t4, 428(sp)
	sw	t4, 268(sp)
	lw	t4, 432(sp)
	sw	t4, 284(sp)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 128(sp)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 228(sp)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 232(sp)
	lw	t4, 232(sp)
	sw	s3, 0(t4)
	addi	a0, zero, 4
	call	malloc
	mv	s3, a0
	sw	s1, 0(s3)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 252(sp)
	lw	t4, 252(sp)
	sw	s11, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 256(sp)
	lw	t4, 256(sp)
	sw	s10, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 248(sp)
	lw	t4, 248(sp)
	sw	s7, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 332(sp)
	lw	t4, 332(sp)
	sw	s6, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 304(sp)
	lw	t4, 304(sp)
	sw	s2, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 96(sp)
	lw	t4, 96(sp)
	sw	s4, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 244(sp)
	lw	t4, 244(sp)
	sw	s0, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 116(sp)
	lw	t4, 116(sp)
	sw	s5, 0(t4)
	addi	a0, zero, 4
	call	malloc
	mv	s7, a0
	sw	s8, 0(s7)
	addi	a0, zero, 4
	call	malloc
	mv	s6, a0
	sw	s9, 0(s6)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 188(sp)
	lw	t4, 188(sp)
	lw	t5, 200(sp)
	sw	t5, 0(t4)
	addi	a0, zero, 4
	call	malloc
	mv	s5, a0
	lw	t4, 104(sp)
	sw	t4, 0(s5)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 308(sp)
	lw	t4, 272(sp)
	lw	t5, 308(sp)
	sw	t4, 0(t5)
	addi	a0, zero, 4
	call	malloc
	mv	s2, a0
	lw	t4, 276(sp)
	sw	t4, 0(s2)
	addi	a0, zero, 4
	call	malloc
	mv	s1, a0
	lw	t4, 180(sp)
	sw	t4, 0(s1)
	addi	a0, zero, 4
	call	malloc
	mv	s0, a0
	lw	t4, 152(sp)
	sw	t4, 0(s0)
	addi	a0, zero, 4
	call	malloc
	mv	s9, a0
	lw	t4, 296(sp)
	sw	t4, 0(s9)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 212(sp)
	lw	t5, 136(sp)
	lw	t4, 212(sp)
	sw	t5, 0(t4)
	addi	a0, zero, 4
	call	malloc
	mv	s11, a0
	lw	t4, 220(sp)
	sw	t4, 0(s11)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 144(sp)
	lw	t4, 112(sp)
	lw	t5, 144(sp)
	sw	t4, 0(t5)
	addi	a0, zero, 4
	call	malloc
	mv	s4, a0
	lw	t4, 124(sp)
	sw	t4, 0(s4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 196(sp)
	lw	t4, 196(sp)
	lw	t5, 204(sp)
	sw	t5, 0(t4)
	addi	a0, zero, 4
	call	malloc
	mv	s8, a0
	lw	t4, 176(sp)
	sw	t4, 0(s8)
	addi	a0, zero, 4
	call	malloc
	mv	s10, a0
	lw	t4, 260(sp)
	sw	t4, 0(s10)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 192(sp)
	lw	t5, 160(sp)
	lw	t4, 192(sp)
	sw	t5, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 224(sp)
	lw	t4, 224(sp)
	lw	t5, 316(sp)
	sw	t5, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 312(sp)
	lw	t5, 164(sp)
	lw	t4, 312(sp)
	sw	t5, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 156(sp)
	lw	t4, 156(sp)
	lw	t5, 324(sp)
	sw	t5, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 100(sp)
	lw	t5, 100(sp)
	lw	t4, 268(sp)
	sw	t4, 0(t5)
	addi	a0, zero, 4
	call	malloc
	mv	t4, a0
	lw	t5, 284(sp)
	sw	t5, 0(t4)
	lw	t5, 128(sp)
	lw	t5, 0(t5)
	lw	t5, 252(sp)
	lw	t5, 0(t5)
	lw	t6, 256(sp)
	lw	t6, 0(t6)
	add	t5, t5, t6
	lw	t6, 248(sp)
	lw	t6, 0(t6)
	add	t6, t5, t6
	lw	t5, 332(sp)
	lw	t5, 0(t5)
	add	t6, t6, t5
	lw	t5, 304(sp)
	lw	t5, 0(t5)
	add	t6, t6, t5
	lw	t5, 96(sp)
	lw	t5, 0(t5)
	add	t6, t6, t5
	lw	t5, 244(sp)
	lw	t5, 0(t5)
	add	t5, t6, t5
	lw	t6, 116(sp)
	lw	t6, 0(t6)
	add	t5, t5, t6
	lw	t6, 0(s7)
	add	t6, t5, t6
	lw	t5, 0(s6)
	add	t6, t6, t5
	lw	t5, 188(sp)
	lw	t5, 0(t5)
	add	t5, t6, t5
	lw	t6, 0(s5)
	add	t5, t5, t6
	lw	t6, 308(sp)
	lw	t6, 0(t6)
	add	t6, t5, t6
	lw	t5, 0(s2)
	add	t6, t6, t5
	lw	t5, 0(s1)
	add	t5, t6, t5
	lw	t6, 0(s0)
	add	t5, t5, t6
	lw	t6, 0(s9)
	add	t6, t5, t6
	lw	t5, 212(sp)
	lw	t5, 0(t5)
	add	t6, t6, t5
	lw	t5, 0(s11)
	add	t6, t6, t5
	lw	t5, 144(sp)
	lw	t5, 0(t5)
	add	t6, t6, t5
	lw	t5, 0(s4)
	add	t6, t6, t5
	lw	t5, 196(sp)
	lw	t5, 0(t5)
	add	t6, t6, t5
	lw	t5, 0(s8)
	add	t6, t6, t5
	lw	t5, 0(s10)
	add	t6, t6, t5
	lw	t5, 192(sp)
	lw	t5, 0(t5)
	add	t6, t6, t5
	lw	t5, 224(sp)
	lw	t5, 0(t5)
	add	t6, t6, t5
	lw	t5, 312(sp)
	lw	t5, 0(t5)
	add	t5, t6, t5
	lw	t6, 156(sp)
	lw	t6, 0(t6)
	add	t6, t5, t6
	lw	t5, 100(sp)
	lw	t5, 0(t5)
	add	t6, t6, t5
	lw	t5, 0(t4)
	add	t6, t6, t5
	addi	t5, zero, 100
	rem	t5, t6, t5
	lw	t6, 128(sp)
	sw	t5, 0(t6)
	lw	t5, 232(sp)
	lw	t6, 0(t5)
	lw	t5, 0(s3)
	rem	t5, t6, t5
	addi	t5, t5, 0
	seqz	t5, t5
	beqz	t5, .L1_3
	j	.L1_1
.L1_1:
	lw	t4, 0(s3)
	lw	t5, 228(sp)
	sw	t4, 0(t5)
	j	.L1_6
.L1_2:
	j	.L1_5
.L1_3:
	lw	a0, 0(s3)
	lw	t5, 232(sp)
	lw	t5, 0(t5)
	lw	t6, 0(s3)
	rem	a1, t5, t6
	lw	t5, 128(sp)
	lw	a2, 0(t5)
	lw	t5, 256(sp)
	lw	a3, 0(t5)
	lw	t5, 248(sp)
	lw	a4, 0(t5)
	lw	t5, 332(sp)
	lw	a5, 0(t5)
	lw	t5, 304(sp)
	lw	a6, 0(t5)
	lw	t5, 96(sp)
	lw	t5, 0(t5)
	sw	t5, 120(sp)
	lw	t5, 244(sp)
	lw	t5, 0(t5)
	sw	t5, 236(sp)
	lw	t5, 116(sp)
	lw	t5, 0(t5)
	sw	t5, 132(sp)
	lw	t5, 0(s7)
	sw	t5, 208(sp)
	lw	t5, 0(s6)
	sw	t5, 288(sp)
	lw	t5, 188(sp)
	lw	t5, 0(t5)
	sw	t5, 328(sp)
	lw	s7, 0(s5)
	lw	t5, 308(sp)
	lw	t5, 0(t5)
	sw	t5, 336(sp)
	lw	s6, 0(s2)
	lw	s5, 0(s1)
	lw	t5, 0(s0)
	lw	t6, 0(s9)
	lw	ra, 212(sp)
	lw	ra, 0(ra)
	lw	t1, 0(s11)
	lw	a7, 144(sp)
	lw	t0, 0(a7)
	lw	t3, 0(s4)
	lw	a7, 196(sp)
	lw	t2, 0(a7)
	lw	s11, 0(s8)
	lw	s3, 0(s10)
	lw	a7, 192(sp)
	lw	s10, 0(a7)
	lw	a7, 224(sp)
	lw	s1, 0(a7)
	lw	a7, 312(sp)
	lw	s2, 0(a7)
	lw	a7, 156(sp)
	lw	s0, 0(a7)
	lw	a7, 100(sp)
	lw	s4, 0(a7)
	lw	t4, 0(t4)
	lw	a7, 120(sp)
	lw	a0, 236(sp)
	sw	a0, 0(sp)
	lw	a0, 132(sp)
	sw	a0, 4(sp)
	lw	a0, 208(sp)
	sw	a0, 8(sp)
	lw	a0, 288(sp)
	sw	a0, 12(sp)
	lw	a0, 328(sp)
	sw	a0, 16(sp)
	sw	s7, 20(sp)
	lw	a0, 336(sp)
	sw	a0, 24(sp)
	sw	s6, 28(sp)
	sw	s5, 32(sp)
	sw	t5, 36(sp)
	sw	t6, 40(sp)
	sw	ra, 44(sp)
	sw	t1, 48(sp)
	sw	t0, 52(sp)
	sw	t3, 56(sp)
	sw	t2, 60(sp)
	sw	s11, 64(sp)
	sw	s3, 68(sp)
	sw	s10, 72(sp)
	sw	s1, 76(sp)
	sw	s2, 80(sp)
	sw	s0, 84(sp)
	sw	s4, 88(sp)
	sw	t4, 92(sp)
	call	gcd2
	lw	t4, 228(sp)
	sw	a0, 0(t4)
	j	.L1_6
.L1_4:
	j	.L1_5
.L1_5:
	j	.L1_6
.L1_6:
	lw	t4, 228(sp)
	lw	a0, 0(t4)
	lw	s11, 148(sp)
	lw	s10, 240(sp)
	lw	s0, 184(sp)
	lw	s1, 140(sp)
	lw	s2, 280(sp)
	lw	s3, 320(sp)
	lw	s4, 168(sp)
	lw	s5, 216(sp)
	lw	s6, 292(sp)
	lw	s7, 172(sp)
	lw	s8, 264(sp)
	lw	s9, 300(sp)
	lw	ra, 108(sp)
	addi	sp, sp, 340
	ret
	.size	gcd1, .-gcd1
	.globl	gcd2
	.p2align	2
	.type	gcd2,@function
gcd2:
.L2_0:
	addi	sp, sp, -340
	sw	ra, 148(sp)
	sw	s11, 132(sp)
	sw	s10, 292(sp)
	sw	s0, 300(sp)
	sw	s1, 288(sp)
	sw	s2, 216(sp)
	sw	s3, 212(sp)
	sw	s4, 204(sp)
	sw	s5, 268(sp)
	sw	s6, 184(sp)
	sw	s7, 328(sp)
	sw	s8, 164(sp)
	sw	s9, 120(sp)
	mv	s11, a0
	mv	s7, a1
	mv	s10, a2
	mv	s5, a3
	mv	s1, a4
	mv	s4, a5
	mv	s2, a6
	mv	s3, a7
	lw	s0, 340(sp)
	lw	s9, 344(sp)
	lw	t4, 348(sp)
	sw	t4, 304(sp)
	lw	t4, 352(sp)
	sw	t4, 180(sp)
	lw	t4, 356(sp)
	sw	t4, 112(sp)
	lw	t4, 360(sp)
	sw	t4, 240(sp)
	lw	t4, 364(sp)
	sw	t4, 136(sp)
	lw	t4, 368(sp)
	sw	t4, 276(sp)
	lw	t4, 372(sp)
	sw	t4, 264(sp)
	lw	t4, 376(sp)
	sw	t4, 144(sp)
	lw	t4, 380(sp)
	sw	t4, 316(sp)
	lw	t4, 384(sp)
	sw	t4, 308(sp)
	lw	t4, 388(sp)
	sw	t4, 256(sp)
	lw	t4, 392(sp)
	sw	t4, 248(sp)
	lw	t4, 396(sp)
	sw	t4, 176(sp)
	lw	t4, 400(sp)
	sw	t4, 172(sp)
	lw	t4, 404(sp)
	sw	t4, 252(sp)
	lw	t4, 408(sp)
	sw	t4, 284(sp)
	lw	t4, 412(sp)
	sw	t4, 208(sp)
	lw	t4, 416(sp)
	sw	t4, 116(sp)
	lw	t4, 420(sp)
	sw	t4, 140(sp)
	lw	t4, 424(sp)
	sw	t4, 152(sp)
	lw	t4, 428(sp)
	sw	t4, 104(sp)
	lw	t4, 432(sp)
	sw	t4, 156(sp)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 192(sp)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 244(sp)
	addi	a0, zero, 4
	call	malloc
	mv	s6, a0
	sw	s11, 0(s6)
	addi	a0, zero, 4
	call	malloc
	mv	s11, a0
	sw	s7, 0(s11)
	addi	a0, zero, 4
	call	malloc
	mv	s7, a0
	sw	s10, 0(s7)
	addi	a0, zero, 4
	call	malloc
	mv	s10, a0
	sw	s5, 0(s10)
	addi	a0, zero, 4
	call	malloc
	mv	s8, a0
	sw	s1, 0(s8)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 228(sp)
	lw	t4, 228(sp)
	sw	s4, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 272(sp)
	lw	t4, 272(sp)
	sw	s2, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 296(sp)
	lw	t4, 296(sp)
	sw	s3, 0(t4)
	addi	a0, zero, 4
	call	malloc
	mv	s2, a0
	sw	s0, 0(s2)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 96(sp)
	lw	t4, 96(sp)
	sw	s9, 0(t4)
	addi	a0, zero, 4
	call	malloc
	mv	s9, a0
	lw	t4, 304(sp)
	sw	t4, 0(s9)
	addi	a0, zero, 4
	call	malloc
	mv	s0, a0
	lw	t4, 180(sp)
	sw	t4, 0(s0)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 124(sp)
	lw	t4, 112(sp)
	lw	t5, 124(sp)
	sw	t4, 0(t5)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 236(sp)
	lw	t5, 236(sp)
	lw	t4, 240(sp)
	sw	t4, 0(t5)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 332(sp)
	lw	t4, 136(sp)
	lw	t5, 332(sp)
	sw	t4, 0(t5)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 188(sp)
	lw	t5, 188(sp)
	lw	t4, 276(sp)
	sw	t4, 0(t5)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 196(sp)
	lw	t4, 196(sp)
	lw	t5, 264(sp)
	sw	t5, 0(t4)
	addi	a0, zero, 4
	call	malloc
	mv	s1, a0
	lw	t4, 144(sp)
	sw	t4, 0(s1)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 220(sp)
	lw	t5, 220(sp)
	lw	t4, 316(sp)
	sw	t4, 0(t5)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 108(sp)
	lw	t5, 108(sp)
	lw	t4, 308(sp)
	sw	t4, 0(t5)
	addi	a0, zero, 4
	call	malloc
	mv	s3, a0
	lw	t4, 256(sp)
	sw	t4, 0(s3)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 324(sp)
	lw	t4, 248(sp)
	lw	t5, 324(sp)
	sw	t4, 0(t5)
	addi	a0, zero, 4
	call	malloc
	mv	s5, a0
	lw	t4, 176(sp)
	sw	t4, 0(s5)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 336(sp)
	lw	t4, 172(sp)
	lw	t5, 336(sp)
	sw	t4, 0(t5)
	addi	a0, zero, 4
	call	malloc
	mv	s4, a0
	lw	t4, 252(sp)
	sw	t4, 0(s4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 320(sp)
	lw	t4, 284(sp)
	lw	t5, 320(sp)
	sw	t4, 0(t5)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 100(sp)
	lw	t5, 100(sp)
	lw	t4, 208(sp)
	sw	t4, 0(t5)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 260(sp)
	lw	t5, 116(sp)
	lw	t4, 260(sp)
	sw	t5, 0(t4)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 200(sp)
	lw	t4, 140(sp)
	lw	t5, 200(sp)
	sw	t4, 0(t5)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 168(sp)
	lw	t4, 152(sp)
	lw	t5, 168(sp)
	sw	t4, 0(t5)
	addi	a0, zero, 4
	call	malloc
	sw	a0, 128(sp)
	lw	t4, 104(sp)
	lw	t5, 128(sp)
	sw	t4, 0(t5)
	addi	a0, zero, 4
	call	malloc
	lw	t4, 156(sp)
	sw	t4, 0(a0)
	lw	t4, 192(sp)
	lw	t4, 0(t4)
	lw	t5, 0(s7)
	lw	t4, 0(s10)
	add	t4, t5, t4
	lw	t5, 0(s8)
	add	t5, t4, t5
	lw	t4, 228(sp)
	lw	t4, 0(t4)
	add	t4, t5, t4
	lw	t5, 272(sp)
	lw	t5, 0(t5)
	add	t5, t4, t5
	lw	t4, 296(sp)
	lw	t4, 0(t4)
	add	t4, t5, t4
	lw	t5, 0(s2)
	add	t5, t4, t5
	lw	t4, 96(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 0(s9)
	add	t4, t5, t4
	lw	t5, 0(s0)
	add	t5, t4, t5
	lw	t4, 124(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 236(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 332(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 188(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 196(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 0(s1)
	add	t4, t5, t4
	lw	t5, 220(sp)
	lw	t5, 0(t5)
	add	t5, t4, t5
	lw	t4, 108(sp)
	lw	t4, 0(t4)
	add	t4, t5, t4
	lw	t5, 0(s3)
	add	t5, t4, t5
	lw	t4, 324(sp)
	lw	t4, 0(t4)
	add	t4, t5, t4
	lw	t5, 0(s5)
	add	t4, t4, t5
	lw	t5, 336(sp)
	lw	t5, 0(t5)
	add	t4, t4, t5
	lw	t5, 0(s4)
	add	t4, t4, t5
	lw	t5, 320(sp)
	lw	t5, 0(t5)
	add	t4, t4, t5
	lw	t5, 100(sp)
	lw	t5, 0(t5)
	add	t5, t4, t5
	lw	t4, 260(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 200(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 168(sp)
	lw	t4, 0(t4)
	add	t5, t5, t4
	lw	t4, 128(sp)
	lw	t4, 0(t4)
	add	t4, t5, t4
	lw	t5, 0(a0)
	add	t4, t4, t5
	addi	t5, zero, 100
	rem	t5, t4, t5
	lw	t4, 192(sp)
	sw	t5, 0(t4)
	lw	t4, 0(s6)
	lw	t5, 0(s11)
	rem	t4, t4, t5
	addi	t4, t4, 0
	seqz	t4, t4
	beqz	t4, .L2_3
	j	.L2_1
.L2_1:
	lw	t4, 0(s11)
	lw	t5, 244(sp)
	sw	t4, 0(t5)
	j	.L2_6
.L2_2:
	j	.L2_5
.L2_3:
	lw	t4, 0(s11)
	sw	t4, 232(sp)
	lw	t4, 0(s6)
	lw	t5, 0(s11)
	rem	a1, t4, t5
	lw	a2, 0(s7)
	lw	a3, 0(s10)
	lw	a4, 0(s8)
	lw	t4, 228(sp)
	lw	a5, 0(t4)
	lw	t4, 272(sp)
	lw	a6, 0(t4)
	lw	t4, 296(sp)
	lw	a7, 0(t4)
	lw	t4, 0(s2)
	sw	t4, 280(sp)
	lw	t4, 96(sp)
	lw	t4, 0(t4)
	sw	t4, 160(sp)
	lw	t4, 0(s9)
	sw	t4, 224(sp)
	lw	t4, 0(s0)
	sw	t4, 312(sp)
	lw	t4, 124(sp)
	lw	s9, 0(t4)
	lw	t4, 236(sp)
	lw	t4, 0(t4)
	lw	t5, 332(sp)
	lw	s8, 0(t5)
	lw	t5, 188(sp)
	lw	s6, 0(t5)
	lw	t5, 196(sp)
	lw	s7, 0(t5)
	lw	ra, 0(s1)
	lw	t5, 220(sp)
	lw	t5, 0(t5)
	lw	t6, 108(sp)
	lw	t6, 0(t6)
	lw	t0, 0(s3)
	lw	t1, 324(sp)
	lw	t1, 0(t1)
	lw	t2, 0(s5)
	lw	t3, 336(sp)
	lw	t3, 0(t3)
	lw	s10, 0(s4)
	lw	s11, 320(sp)
	lw	s5, 0(s11)
	lw	s11, 100(sp)
	lw	s2, 0(s11)
	lw	s11, 260(sp)
	lw	s11, 0(s11)
	lw	s0, 200(sp)
	lw	s1, 0(s0)
	lw	s0, 168(sp)
	lw	s3, 0(s0)
	lw	s0, 128(sp)
	lw	s0, 0(s0)
	lw	s4, 0(a0)
	lw	a0, 232(sp)
	lw	a0, 280(sp)
	sw	a0, 0(sp)
	lw	a0, 160(sp)
	sw	a0, 4(sp)
	lw	a0, 224(sp)
	sw	a0, 8(sp)
	lw	a0, 312(sp)
	sw	a0, 12(sp)
	sw	s9, 16(sp)
	sw	t4, 20(sp)
	sw	s8, 24(sp)
	sw	s6, 28(sp)
	sw	s7, 32(sp)
	sw	ra, 36(sp)
	sw	t5, 40(sp)
	sw	t6, 44(sp)
	sw	t0, 48(sp)
	sw	t1, 52(sp)
	sw	t2, 56(sp)
	sw	t3, 60(sp)
	sw	s10, 64(sp)
	sw	s5, 68(sp)
	sw	s2, 72(sp)
	sw	s11, 76(sp)
	sw	s1, 80(sp)
	sw	s3, 84(sp)
	sw	s0, 88(sp)
	sw	s4, 92(sp)
	call	gcd
	lw	t4, 244(sp)
	sw	a0, 0(t4)
	j	.L2_6
.L2_4:
	j	.L2_5
.L2_5:
	j	.L2_6
.L2_6:
	lw	t4, 244(sp)
	lw	a0, 0(t4)
	lw	s11, 132(sp)
	lw	s10, 292(sp)
	lw	s0, 300(sp)
	lw	s1, 288(sp)
	lw	s2, 216(sp)
	lw	s3, 212(sp)
	lw	s4, 204(sp)
	lw	s5, 268(sp)
	lw	s6, 184(sp)
	lw	s7, 328(sp)
	lw	s8, 164(sp)
	lw	s9, 120(sp)
	lw	ra, 148(sp)
	addi	sp, sp, 340
	ret
	.size	gcd2, .-gcd2
	.globl	main
	.p2align	2
	.type	main,@function
main:
.L3_0:
	addi	sp, sp, -104
	sw	ra, 100(sp)
	sw	s1, 96(sp)
	call	mx__init
	addi	a0, zero, 4
	call	malloc
	mv	s1, a0
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
	sw	zero, 0(s1)
	j	.L3_2
.L3_1:
	j	.L3_2
.L3_2:
	lw	a0, 0(s1)
	lw	s1, 96(sp)
	lw	ra, 100(sp)
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
